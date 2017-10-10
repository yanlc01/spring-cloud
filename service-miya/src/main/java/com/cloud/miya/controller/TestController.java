package com.cloud.miya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/", produces = {"application/json;charset=utf-8"})
public class TestController {

	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path = "/hi", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
//		System.out.println("hi " + name + ", I am from port : " + port);
		return "hi " + name + ", I am from port : " + port;
	}
	
	@RequestMapping("/miya")
    public String home(){
        return restTemplate.getForObject("http://localhost:8763/info", String.class);
    }
	
	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String info() {
		return "I'm server-miya";
	}
	
}
