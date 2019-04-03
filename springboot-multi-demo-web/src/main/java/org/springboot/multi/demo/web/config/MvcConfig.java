package org.springboot.multi.demo.web.config;

import org.springboot.multi.demo.web.interceptor.CustomInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * 
 * @author Think
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	CustomInterceptor customInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customInterceptor);
	}


}
