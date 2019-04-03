package org.springboot.multi.demo.web.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springboot.multi.demo.web.properties.DruidDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 不在使用，使用配置文件
 * @author Think
 *
 */
//@Configuration
//@EnableConfigurationProperties(value = DruidDataSourceProperties.class)
@Deprecated 
public class DruidDataSourceConfig {

	@Autowired
	private DruidDataSourceProperties druidDataSourceProperties;

//	@Bean
//	public DataSource dataSource() {
//		System.out.println("初始化-----------------"+druidDataSourceProperties);
//		DruidDataSource druidDataSource = new DruidDataSource();
//		druidDataSource.setUsername(druidDataSourceProperties.getUsername());
//		druidDataSource.setPassword(druidDataSourceProperties.getPassword());
//		druidDataSource.setUrl(druidDataSourceProperties.getJdbcUrl());
//		druidDataSource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
//		druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
//		druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
//		druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
//		druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
//		druidDataSourceProperties.setPoolPreparedStatements(druidDataSourceProperties.isPoolPreparedStatements());
//		return druidDataSource;
//	}

	/**
	 * 配置访问druid监控
	 * @return
	 */
	@Bean
	public ServletRegistrationBean statViewSerlvet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		//初始化参数initParams
		Map<String, Object> initParameters = new HashMap<>();
		//登录查看信息的账号密码
		initParameters.put("loginUsername", "admin");
		initParameters.put("loginPassword", "123456");
		bean.setInitParameters(initParameters);
		return bean;

	}

	/**
	 * 过滤不需要监控的后缀
	 * @return
	 */
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		System.out.println("过滤===========");
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//		
//		 //添加过滤规则
//		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//
//		Map<String, Object> initParams = new HashMap<>();
//		//添加不需要忽略的格式信息
//		initParams.put("exclusions", "*.js,*.css,/druid/*");
//		filterRegistrationBean.setInitParameters(initParams);
//		return filterRegistrationBean;
//
//	}
}
