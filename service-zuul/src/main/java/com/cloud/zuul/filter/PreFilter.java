package com.cloud.zuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {
	private final Logger logger = LoggerFactory.getLogger(PreFilter.class);

	/**
	 * 过滤器的具体逻辑。
	 * 可以很复杂，可以sql、nosql去判断该接口有没有权限去访问
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			logger.warn("token is empty");
			ctx.setSendZuulResponse(false);//对该请求不进行路由，true：对请求进行路由
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().print("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		logger.info("ok");
		return null;
	}

	/**
	 * 这里可以写逻辑判断，是否要过滤，这里true，永远过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 返回一个字符串，代表过滤器的内容
	 * pre：路由之前
	 * routing：路由之时
	 * post：路由之后
	 * error：发生错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
