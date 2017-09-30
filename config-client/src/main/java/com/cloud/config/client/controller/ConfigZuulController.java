package com.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//指示Config客户端在服务器参数刷新时，也刷新注入的属性值
@RequestMapping(value = "/config", produces = {"application/json; charset=UTF-8"})
public class ConfigZuulController {

	@Value("${from}")
	private String from;
	
	@RequestMapping("/from")
	public String get() {
		return from;
	}
	
}
