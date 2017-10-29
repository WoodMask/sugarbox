package com.sugarbox.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@ResponseBody
	@RequestMapping(value="hello")
	public String index() {
		return "hello,mask";
	}
	
	@ResponseBody
	@RequestMapping(value="index")
	public ModelAndView hello() {
		return new ModelAndView("index");
	}
}
