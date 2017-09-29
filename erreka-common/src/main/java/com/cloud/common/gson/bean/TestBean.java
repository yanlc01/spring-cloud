package com.cloud.common.gson.bean;

import com.cloud.common.gson.CommonGsonBuilder;
import lombok.Data;

@Data
public class TestBean {

	private String uuid;
	
	private String name;
	
	private Integer sex;
	
	private Integer age;
	
	public String toJson() {
		return CommonGsonBuilder.create().toJson(this);
	}
	
	public TestBean fromJson(String json) {
		return CommonGsonBuilder.create().fromJson(json, TestBean.class);
	}
	
}
