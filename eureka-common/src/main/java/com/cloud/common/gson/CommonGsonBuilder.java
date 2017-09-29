package com.cloud.common.gson;

import com.cloud.common.gson.adapter.TestAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yanlc
 *
 */
public class CommonGsonBuilder {

	private static GsonBuilder INSTANCE = new GsonBuilder();
	
	static {
		//禁止html escape解析
		INSTANCE.disableHtmlEscaping();
		
		//基础解析适配器
		INSTANCE.registerTypeHierarchyAdapter(TestAdapter.class, new TestAdapter());
		
	}
	
	public static Gson create() {
		return INSTANCE.create();
	}
}
