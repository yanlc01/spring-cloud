package com.cloud.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestHolderUtil {
	
	public static final String SESSION_WEB = "SESSION_WEB";
	
	public static HttpServletRequest getRequest() {
		return RequestHolderUtil.getServletRequestAttributes().getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		return RequestHolderUtil.getServletRequestAttributes().getResponse();
	}
	
	public static HttpSession getHttpSession() {
		return RequestHolderUtil.getRequest().getSession();
	}
	
	public static Object getSessionAttribute(String name) {
		return RequestHolderUtil.getHttpSession().getAttribute(name);
	}
	
	public static void setSessionAttribute(String name, Object obj) {
		RequestHolderUtil.getHttpSession().setAttribute(name, obj);
	}
	
	public static void clearSessionAttribute(String name) {
		RequestHolderUtil.getHttpSession().removeAttribute(name);
	}
	
	private static ServletRequestAttributes getServletRequestAttributes() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
	}

}
