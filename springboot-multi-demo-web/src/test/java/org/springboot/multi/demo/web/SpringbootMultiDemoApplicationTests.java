package org.springboot.multi.demo.web;

import javax.sql.DataSource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMultiDemoApplicationTests {

	@Autowired
	DataSource dataSource;
	
//	@Autowired
//	private JdbcTemplate dataSource;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testDb() {
		System.out.println("自动装配数据源的类型:"+dataSource.getClass());
		
	}

		
}
