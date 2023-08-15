package com.springhibernatedemo.main;

import java.util.List;
import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springhibernatedemo.model.Employee;
import com.springhibernatedemo.model.EmployeeDetail;
import com.springhibernatedemo.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		Transaction tx = session.beginTransaction();

		EmployeeDetail employeeDetail = new EmployeeDetail("10th Street", "LA", "San Francisco", "U.S.");

		Employee employee = new Employee("Nina", "Mayers", new Date(121212), "114-857-965");
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);

//		session.save(employee);

		// Hibernate Query Language(HQL)
		Query query = session.createQuery("from Employee e");
		List<Employee> employees = query.list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstname() + " , " + employee1.getLastname() + ", "
					+ employee1.getEmployeeDetail().getState());
		}
		tx.commit();
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();

	}

}
