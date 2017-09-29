package com.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.feign.service.hystrix.SchedualHiServiceHystrix;

//value：表示访问eureka-client服务
//fallback：表示访问断路器类
@FeignClient(value = "service-hi", fallback = SchedualHiServiceHystrix.class)
public interface SchedualHiService {

	@RequestMapping(value = "/hi")//表示访问eureka-client服务的"/hi"接口
	String sayHi(@RequestParam(value = "name") String name);//这里属性必须指明 value = "name"
	
}
