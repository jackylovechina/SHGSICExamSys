package com.exam.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.mapper.QuestionTypeMapper;
import com.exam.pojo.QuestionType;

@Controller
public class QuestionTypeController {

	@Autowired
	QuestionTypeMapper questionTypeMapper;

	@RequestMapping(value = "/insertQuestionType")
	@ResponseBody
	public Map<String, Object> insertQuestionType(HttpServletRequest request, HttpServletResponse response) {

		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(typeName);
		int i = 0;
		try {
			i = questionTypeMapper.insertQuestionType(typeName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常");
			// e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/deleteQuestionType")
	@ResponseBody
	public Map<String, Object> deleteQuestionType(HttpServletRequest request, HttpServletResponse response) {
		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = questionTypeMapper.deleteQuestionType(typeName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;

	}

	@RequestMapping(value = "/updateQuestionType")
	@ResponseBody
	public Map<String, Object> updateQuestionType(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QuestionType questionType = new QuestionType();
		questionType.setID(id);
		questionType.setTypeName(typeName);

		int i = questionTypeMapper.updateQuestionType(questionType);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/selectQuestionType")
	@ResponseBody
	public List<QuestionType> selectQuestionType(HttpServletRequest request, HttpServletResponse response) {
		List<QuestionType> questionTypes = questionTypeMapper.selectQuestionType();
		return questionTypes;
	}

}
