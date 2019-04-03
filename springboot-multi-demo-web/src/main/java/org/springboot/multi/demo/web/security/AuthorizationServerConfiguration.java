package org.springboot.multi.demo.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 认证服务器配置
 * 
 */
@Configuration
@EnableAuthorizationServer // 注解开启验证服务器
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static final String CLIEN_ID_ONE = "client_1"; // 客户端1 用来标识客户的Id
	private static final String CLIEN_ID_TWO = "client_2"; // 客户端2
	private static final String CLIEN_ID_THREE = "client_3"; // 客户端3

	private static final String CLIENT_SECRET = "secret"; // secret客户端安全码

	private static final String GRANT_TYPE_PASSWORD = "password"; // 密码模式授权模式
	private static final String AUTHORIZATION_CODE = "authorization_code"; // 授权码模式
																			// 授权码模式使用到了回调地址，是最为复杂的方式，通常网站中经常出现的微博，qq第三方登录，都会采用这个形式。
	private static final String REFRESH_TOKEN = "refresh_token"; //
	private static final String IMPLICIT = "implicit"; // 简化授权模式
	private static final String GRANT_TYPE = "client_credentials"; // 客户端模式

	private static final String SCOPE_READ = "read";
	private static final String SCOPE_WRITE = "write";
	private static final String TRUST = "trust";
	private static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60; //
	private static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60; //
	private static final String RESOURCE_ID = "order"; // 指定哪些资源是需要授权验证的

	/**
	 * 认证方式 注入authenticationManager 来支持 password grant type
	 */
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// password 方案二：用 BCrypt 对密码编码
		// String secret = new BCryptPasswordEncoder().encode(CLIENT_SECRET); // 用
		// BCrypt 对密码编码
		// password 方案三：支持多种编码，通过密码的前缀区分编码方式
		// String
		// secret="{bcrypt}"+PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(CLIENT_SECRET);
		String secret = "{bcrypt}" + new BCryptPasswordEncoder().encode(CLIENT_SECRET);
		// 配置3个个客户端,一个用于password认证、一个用于client认证、一个用于authorization_code认证
		clients.inMemory() // 使用in-memory存储
				.withClient(CLIEN_ID_ONE) // client_id用来标识客户的Id 客户端1
				.resourceIds(RESOURCE_ID).authorizedGrantTypes(GRANT_TYPE, REFRESH_TOKEN) // 允许授权类型 客户端授权模式
				.scopes(SCOPE_READ, SCOPE_WRITE) // 允许授权范围
				.authorities("oauth2") // 客户端可以使用的权限
				.secret(secret) // secret客户端安全码
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS) // token 时间秒
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS)// 刷新token 时间 秒
				.and().withClient(CLIEN_ID_TWO) // client_id用来标识客户的Id 客户端 2
				.resourceIds(RESOURCE_ID).authorizedGrantTypes(GRANT_TYPE_PASSWORD, REFRESH_TOKEN) // 允许授权类型 密码授权模式
				.scopes(SCOPE_READ, SCOPE_WRITE) // 允许授权范围
				.authorities("oauth2") // 客户端可以使用的权限
				.secret(secret) // secret客户端安全码
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS) // token 时间秒
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS); // 刷新token 时间 秒
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory)).authenticationManager(authenticationManager)
				.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)// 支持GET POST 请求获取token
				.userDetailsService(userDetailsService)// 必须注入userDetailsService否则根据refresh_token无法加载用户信息
		// .reuseRefreshTokens(true); // //开启刷新token
		;

	}

	/**
	 * 认证服务器的安全配置
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()") // 允许接口/oauth/check_token 被调用
				.checkTokenAccess("permitAll()") // isAuthenticated():排除anonymous
				.allowFormAuthenticationForClients();// 允许表单认证

	}

}