package com.exam.mapper;

import java.util.List;

import com.exam.pojo.Role;

public interface RoleMapper {

	public int insertRole(String roleName);

	public int deleteRole(String roleName);
	
	public int updateRole(Role role);
	
	public List<Role> selectRole();
}
