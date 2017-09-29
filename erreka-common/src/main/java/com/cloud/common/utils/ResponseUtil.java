package com.cloud.common.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void responseJson(int code, String message, HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print("");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
