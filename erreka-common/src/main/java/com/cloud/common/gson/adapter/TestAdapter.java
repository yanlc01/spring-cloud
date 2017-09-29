package com.cloud.common.gson.adapter;

import java.lang.reflect.Type;

import com.cloud.common.gson.bean.TestBean;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TestAdapter implements JsonSerializer<TestBean>, JsonDeserializer<TestBean> {

	@Override
	public JsonElement serialize(TestBean src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject obj = new JsonObject();
		obj.addProperty("uuid", src.getUuid());
		obj.addProperty("name", src.getName());
		obj.addProperty("sex", src.getSex());
		obj.addProperty("age", src.getAge());
		return obj;
	}
	
	@Override
	public TestBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject obj = json.getAsJsonObject();
		
		TestBean bean = new TestBean();
		bean.setUuid(obj.get("uuid").getAsString());
		bean.setName(obj.get("name").getAsString());
		bean.setSex(obj.get("sex").getAsInt());
		bean.setAge(obj.get("age").getAsInt());
		
		return bean;
	}
	
}
