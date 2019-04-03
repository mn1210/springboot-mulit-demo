package org.springboot.multi.demo.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring-Security 配置
 * @author
 * @date
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		// password 方案二：用 BCrypt 对密码编码
		// String finalPassword = bCryptPasswordEncoder.encode("123456");
		// password 方案三：支持多种编码，通过密码的前缀区分编码方式
		String finalPassword = "{bcrypt}" + bCryptPasswordEncoder.encode("123456");
		System.out.println("finalPassword:" + finalPassword);
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
		manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());
		return manager;
	}

	// password 方案三：支持多种编码，通过密码的前缀区分编码方式,推荐
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * 配置用户签名服务 主要是user-details 机制，
	 *
	 * @param auth
	 *            签名管理器构造器，用于构建用户具体权限控制
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	/**
	 * 这一步的配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户 Spring Boot 2
	 * 配置，这里要bean 注入,支持password模式要配置AuthenticationManager
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

	/**
	 * 设置获取token的url
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.requestMatchers().anyRequest().and().authorizeRequests().antMatchers("/oauth/**")
				// .csrf().disable()
				.permitAll();
	}

}