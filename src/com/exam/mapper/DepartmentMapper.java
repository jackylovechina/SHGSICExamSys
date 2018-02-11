package com.exam.mapper;

import java.util.List;

import com.exam.pojo.Department;

public interface DepartmentMapper {

	public int insertDepartment(String departmentName);

	public int deleteDepartment(String departmentName);

	public int updateDepartment(Department department);

	public List<Department> selectDepartment();

}
