package com.cloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")//创建熔断器，并指定熔断方法
	public String sayHi(String name) {
		return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
	}
	
	public String hiError(String name) {
		return String.format("hi %s, error has happened", name);
	}
	
}
