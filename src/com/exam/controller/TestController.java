package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.mapper.TestMapper;
import com.exam.pojo.Test;

@Controller
public class TestController {

	@Autowired
	TestMapper testMapper;

	private static Logger log = Logger.getLogger(Test.class);
	
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public Test testPage(HttpServletRequest request, HttpServletResponse response) {
		
		Test test=testMapper.selectTestByID(101);

		log.info("test");
		return test;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView getView(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("MyJsp");
		return modelAndView;
		
	}

}
