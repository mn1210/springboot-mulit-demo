package org.springboot.multi.demo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * 自定义过滤器
 * @author Think
 *
 */
@Component
public class CustomFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("TulingFilter的doFilter方法");
		filterChain.doFilter(servletRequest,servletResponse);
		
	}
	
	

}
