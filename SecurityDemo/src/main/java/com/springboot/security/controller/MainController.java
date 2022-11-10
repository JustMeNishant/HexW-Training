package com.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/hello/public")
	private String sayHello() {
		return "hello public";
	}
	
	@GetMapping("/hello/private")
	private String sayHelloPrivate() {
		return "hello private";
	}
}
