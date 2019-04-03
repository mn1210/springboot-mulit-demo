package org.springboot.multi.demo.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping("order/t1")
	public String getT1() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
		return "OK1";
	}
	
	@GetMapping("t2")
	public String getT2() {
		return "OK2";
	}
}
