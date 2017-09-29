package com.cloud.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * API返回JSON格式数据
 * @author yanlc
 *
 */
public class Result {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	private STATUS status;
	private int code;
	private String message;
	private Object result;
	
	public Result() {
		super();
	}

	public Result(STATUS status, int code, String message, Object result) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}

	//success
	public static Result success(int code, String message, Object result) {
		return new Result(STATUS.SUCCESS, code, message, result);
	}
	public static Result success(String message, Object result) {
		return new Result(STATUS.SUCCESS, STATUS.SUCCESS.getValue(), message, result);
	}
	public static Result success(int code, String message) {
		return new Result(STATUS.SUCCESS, code, message, null);
	}
	public static Result success(String message) {
		return new Result(STATUS.SUCCESS, STATUS.SUCCESS.getValue(), message, null);
	}
	
	//fail
	public static Result fail(int code, String message, Object result) {
		return new Result(STATUS.FAIL, code, message, result);
	}
	public static Result fail(int code, String message) {
		return new Result(STATUS.FAIL, code, message, null);
	}
	public static Result fail(String message) {
		return new Result(STATUS.FAIL, STATUS.FAIL.getValue(), message, null);
	}

	public enum STATUS {
		SUCCESS(200),
		FAIL(400);
		
		private int value;

		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		private STATUS(int value) {
			this.value = value;
		}
	}
	
	private static SerializeConfig config = new SerializeConfig();
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this, config, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
	}
	
	public String toGson(ExclusionStrategy strategy) {
		Gson gson = new GsonBuilder().setExclusionStrategies(strategy).create();
		return gson.toJson(this);
	}
	
}
