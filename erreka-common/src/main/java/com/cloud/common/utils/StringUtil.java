package com.cloud.common.utils;

import org.springframework.util.StringUtils;

public class StringUtil {
	
	
	public static boolean isEmpty(String value) {
		return StringUtils.isEmpty(value);
	}
	
	public static boolean isEmpty(String ... value) {
		if (value != null) {
			for (String val : value) {
				if (StringUtils.isEmpty(val)) {
					return true;
				}
			}
		} else {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isEmpty(""));
		System.out.println(isEmpty("1",""));
		System.out.println(isEmpty("1","2"));
	}
}
