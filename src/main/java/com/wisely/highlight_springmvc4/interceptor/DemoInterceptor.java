package com.wisely.highlight_springmvc4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DemoInterceptor extends HandlerInterceptorAdapter{//或者实现接口HandlerInterceptor
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
	@Override //注意返回值是void
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
		long startTime = (Long) request.getAttribute("startTime"); //需要作类型转换
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次请求处理时间为：" + new Long(endTime-startTime) + "ms");//小技巧
		request.setAttribute("handlingTime", endTime-startTime);
	}

}
