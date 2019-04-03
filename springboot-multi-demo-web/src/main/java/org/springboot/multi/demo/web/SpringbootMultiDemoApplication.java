package org.springboot.multi.demo.web;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
@ComponentScan(basePackages={"org.springboot.multi.demo.*"})
@MapperScan(basePackages= "org.springboot.multi.demo.dao.*")
public class SpringbootMultiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMultiDemoApplication.class, args);
	}

}
