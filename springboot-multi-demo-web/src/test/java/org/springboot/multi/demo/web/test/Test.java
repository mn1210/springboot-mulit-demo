package org.springboot.multi.demo.web.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 加密
		String encodedPassword = passwordEncoder.encode("123");
System.out.println(encodedPassword);
//$2a$10$zW.lUKmejMn3JId9ohgz3e1nRhySkWQFKiqluPVgHHbGNsuHcJf9G 123456
	}

}
