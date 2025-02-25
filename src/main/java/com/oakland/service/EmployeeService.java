package com.oakland.service;

import java.util.List;

import com.oakland.model.Employee;

public interface EmployeeService {

	void registerEmployee(Employee employee);

	Employee getEmployeeByLoginIdAndPassword(String loginId, String password);

	List<Employee> getAllEmployees();

}
