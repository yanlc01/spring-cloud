package com.cloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.ribbon.service.HelloService;

@RestController
@RequestMapping(value = "/ribbon", produces = {"application/json; charset=UTF-8"})
public class ConsumerController {
	
	@Autowired
	private HelloService helloService;

	@RequestMapping("/hi")
	public String sayHello(@RequestParam String name) {
		return helloService.sayHi(name);
	}
	
}
