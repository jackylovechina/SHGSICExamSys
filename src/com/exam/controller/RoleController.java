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

import com.exam.mapper.RoleMapper;
import com.exam.pojo.Role;

@Controller
public class RoleController {

	@Autowired
	RoleMapper roleMapper;
	
	@RequestMapping(value = "/insertRole")
	@ResponseBody
	public Map<String, Object> insertRole(HttpServletRequest request, HttpServletResponse response) {

		
		String roleName = null;
		try {
			roleName = new String((request.getParameter("roleName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(roleName);
		int i = 0;
		try {
			i = roleMapper.insertRole(roleName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("异常");
			// e.printStackTrace();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/deleteRole")
	@ResponseBody
	public Map<String, Object> deleteRole(HttpServletRequest request, HttpServletResponse response) {
		String roleName = null;
		try {
			roleName = new String((request.getParameter("roleName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = roleMapper.deleteRole(roleName);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;

	}

	@RequestMapping(value = "/updateRole")
	@ResponseBody
	public Map<String, Object> updateRole(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String roleName = null;
		try {
			roleName = new String((request.getParameter("roleName")).getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Role role = new Role();
		role.setID(id);
		role.setRoleName(roleName);

		int i = roleMapper.updateRole(role);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", i);

		return resultMap;
	}

	@RequestMapping(value = "/selectRole")
	@ResponseBody
	public List<Role> selectRole(HttpServletRequest request, HttpServletResponse response) {
		List<Role> roles = roleMapper.selectRole();
		return roles;
	}
}
