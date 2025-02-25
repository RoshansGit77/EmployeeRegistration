package com.oakland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oakland.dao.EmployeeDAO;
import com.oakland.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Transactional
	@Override
	public void registerEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Transactional(readOnly = true)
	@Override
	public Employee getEmployeeByLoginIdAndPassword(String loginId, String password) {
		Employee emp = employeeDao.getEmployeeByLoginIdAndPassword(loginId, password);
		return emp;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = (List<Employee>) employeeDao.getAllEmployees();
		return list;
	}
}
