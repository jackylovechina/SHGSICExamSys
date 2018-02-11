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

import com.exam.mapper.DepartmentMapper;
import com.exam.pojo.Department;

@Controller

public class DepartmentController {

	@Autowired
	DepartmentMapper departmentMapper;

	@RequestMapping(value = "/insertDepartment")
	@ResponseBody
	public Map<String, Object> insertDepartment(HttpServletRequest request, HttpServletResponse response) {

		String departmentName = null;
		try {
			departmentName = new String((request.getParameter("departmentName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(departmentName);
		int i = 0;
		try {
			i = departmentMapper.insertDepartment(departmentName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常");
			// e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/deleteDepartment")
	@ResponseBody
	public Map<String, Object> deleteDepartment(HttpServletRequest request, HttpServletResponse response) {
		String departmentName = null;
		try {
			departmentName = new String((request.getParameter("departmentName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = departmentMapper.deleteDepartment(departmentName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;

	}

	@RequestMapping(value = "/updateDepartment")
	@ResponseBody
	public Map<String, Object> updateDepartment(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String departmentName = null;
		try {
			departmentName = new String((request.getParameter("departmentName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Department department = new Department();
		department.setID(id);
		department.setDepartmentName(departmentName);

		int i = departmentMapper.updateDepartment(department);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/selectDepartment")
	@ResponseBody
	public List<Department> selectDepartment(HttpServletRequest request, HttpServletResponse response) {
		List<Department> departments = departmentMapper.selectDepartment();
		return departments;
	}

}
