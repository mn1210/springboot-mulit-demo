package org.springboot.multi.demo.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	private static final String RESOURCE_ID = "order";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(true);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/order/**").authenticated(); // 配置users访问控制，必须认证过后才可以访问
		// .and()
		// .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint())
		// //认证失败的业务处理
		// .and()
		// .logout()
		// .logoutUrl("/oauth/logout")
		// .logoutSuccessHandler(customLogoutSuccessHandler()); //退出成功的业务处理
	}
}
