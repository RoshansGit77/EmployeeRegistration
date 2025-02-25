package com.oakland.dao;

import java.util.List;

import com.oakland.model.Employee;

public interface EmployeeDAO {

	void saveEmployee(Employee employee);

	Employee getEmployeeByLoginIdAndPassword(String loginId, String password);

	List<Employee> getAllEmployees();

}
