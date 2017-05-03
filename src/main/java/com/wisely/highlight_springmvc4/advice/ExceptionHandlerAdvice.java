package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //控制器建言 组合了@Component注解
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value=Exception.class) //定义全局处理
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute //键值对添加到全局
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder //定制WebDataBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id"); //忽略request的参数id
	}
}
