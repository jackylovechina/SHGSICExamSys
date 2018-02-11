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

import com.exam.mapper.ContentTypeMapper;
import com.exam.pojo.ContentType;

@Controller
public class ContentTypeController {

	@Autowired
	ContentTypeMapper contentTypeMapper;

	@RequestMapping(value = "/insertContentType")
	@ResponseBody
	public Map<String, Object> insertContent(HttpServletRequest request, HttpServletResponse response) {

		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(typeName);
		int i = 0;
		try {
			i = contentTypeMapper.insertContentType(typeName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常");
			// e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/deleteContentType")
	@ResponseBody
	public Map<String, Object> deleteContent(HttpServletRequest request, HttpServletResponse response) {
		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = contentTypeMapper.deleteContentType(typeName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;

	}

	@RequestMapping(value = "/updateContentType")
	@ResponseBody
	public Map<String, Object> updateContent(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String typeName = null;
		try {
			typeName = new String((request.getParameter("typeName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ContentType contentType = new ContentType();
		contentType.setID(id);
		contentType.setTypeName(typeName);

		int i = contentTypeMapper.updateContentType(contentType);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/selectContentType")
	@ResponseBody
	public List<ContentType> selectContent(HttpServletRequest request, HttpServletResponse response) {
		List<ContentType> contentTypes = contentTypeMapper.selectContentType();
		return contentTypes;
	}

}
