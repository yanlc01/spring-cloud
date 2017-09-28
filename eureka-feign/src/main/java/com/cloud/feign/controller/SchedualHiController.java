package com.cloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.feign.service.SchedualHiService;

@RestController
@RequestMapping(value = "/feign", produces = {"application/json;charset=UTF-8"})
public class SchedualHiController {
	
	@Autowired
	private SchedualHiService schedualHiService;
	
	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return schedualHiService.sayHi(name);
	}

}
