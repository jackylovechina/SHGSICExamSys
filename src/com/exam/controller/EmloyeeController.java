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

import com.exam.mapper.EmployeeMapper;
import com.exam.pojo.Employee;

@Controller
public class EmloyeeController {

	@Autowired
	EmployeeMapper employeeMapper;

	@RequestMapping(value = "/insertEmployee")
	@ResponseBody
	public Map<String, Object> insertEmployee(HttpServletRequest request, HttpServletResponse response) {

		long Role_ID;
		long Dep_ID;
		String Name = null;
		String Number = null;
		String Sex = null;
		String Password = null;
		Role_ID = Long.parseLong(request.getParameter("role_ID"));
		Dep_ID = Long.parseLong(request.getParameter("dep_ID"));
		try {
			Name = new String((request.getParameter("name")).getBytes("iso-8859-1"), "utf-8");
			Number = new String((request.getParameter("number")).getBytes("iso-8859-1"), "utf-8");
			Sex = new String((request.getParameter("sex")).getBytes("iso-8859-1"), "utf-8");
			Password = new String((request.getParameter("password")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee employee = new Employee();
		employee.setRole_ID(Role_ID);
		employee.setDep_ID(Dep_ID);
		employee.setName(Name);
		employee.setNumber(Number);
		employee.setSex(Sex);
		employee.setPassword(Password);

		int i = employeeMapper.insertEmployee(employee);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", i);

		return result;
	}

	@RequestMapping(value = "/deleteEmployee")
	@ResponseBody
	public Map<String, Object> deleteEmployee(HttpServletRequest request, HttpServletResponse response) {

		String Number = null;
		try {
			Number = new String((request.getParameter("number")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = employeeMapper.deleteEmployee(Number);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", i);

		return result;
	}

	@RequestMapping(value = "/updateEmployee")
	@ResponseBody
	public Map<String, Object> updateEmployee(HttpServletRequest request, HttpServletResponse response) {

		long Role_ID;
		long Dep_ID;
		String Name = request.getParameter("name");
		String Number = request.getParameter("number");
		String Sex = request.getParameter("sex");
		String Password = request.getParameter("password");

		Role_ID = Long.parseLong(request.getParameter("role_ID"));
		Dep_ID = Long.parseLong(request.getParameter("dep_ID"));

		try {
			if (Name != null)
				Name = new String(Name.getBytes("iso-8859-1"), "utf-8");
			if (Number != null)
				Number = new String(Number.getBytes("iso-8859-1"), "utf-8");
			if (Sex != null)
				Sex = new String(Sex.getBytes("iso-8859-1"), "utf-8");
			if (Password != null)
				Password = new String(Password.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee employee = new Employee();
		employee.setRole_ID(Role_ID);
		employee.setDep_ID(Dep_ID);
		employee.setName(Name);
		employee.setNumber(Number);
		employee.setSex(Sex);
		employee.setPassword(Password);

		int i = employeeMapper.updateEmployee(employee);

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("result", i);

		return result;
	}

	@RequestMapping(value = "/selectEmployee")
	@ResponseBody 
	public List<Employee> selectEmployee(HttpServletRequest request, HttpServletResponse response) {

		List<Employee> employees=employeeMapper.selectEmployee();
				
		return employees;

	}
}
