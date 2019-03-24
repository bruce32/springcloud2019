package com.alibaba.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author brucesu
 *
 */
public class MyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		System.out.println("shouldFilter");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("hello");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println("--->>> TokenFilter " + request.getMethod() + ", " + request.getRequestURL().toString());

		String token = request.getParameter("token");// 获取请求的参数

		if (StringUtils.isNotBlank(token)) {
			ctx.setSendZuulResponse(true); // 对请求进行路由
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);
			return null;
		} else {
			ctx.setSendZuulResponse(false); // 不对其进行路由
			ctx.setResponseStatusCode(400);
			ctx.setResponseBody("token is empty");
			ctx.set("isSuccess", false);
			return null;
		}
	}

	@Override
	public String filterType() {
		System.out.println("filterType");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("filterOrder");
		return 0;
	}

}
