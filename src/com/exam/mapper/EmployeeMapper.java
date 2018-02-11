package com.exam.mapper;

import java.util.List;

import com.exam.pojo.Employee;

public interface EmployeeMapper {

	public int insertEmployee(Employee employee);

	public int deleteEmployee(String number);

	public int updateEmployee(Employee employee);

	public List<Employee> selectEmployee();

}
