package com.oakland.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.oakland.model.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void saveEmployee(Employee employee) {
		Session session = sf.getCurrentSession();
		session.save(employee);
	}

	@Override
	public Employee getEmployeeByLoginIdAndPassword(String loginId, String password) {
		Session session = sf.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee where loginId = :loginId and password = :password",
				Employee.class);
		query.setParameter("loginId", loginId);
		query.setParameter("password", password);
		return query.uniqueResult();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sf.getCurrentSession();
		Query<Employee> list = session.createQuery("from Employee", Employee.class);
		return list.getResultList();
	}
}
