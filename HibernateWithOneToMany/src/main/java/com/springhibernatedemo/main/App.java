package com.springhibernatedemo.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springhibernatedemo.model.Department;
import com.springhibernatedemo.model.Employee;
import com.springhibernatedemo.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		Transaction tx = session.beginTransaction();
		Department department = new Department();
		department.setDepartmentName("Sales");

		session.save(department);

		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");

		emp1.setFirstname("Indrajeet");
		emp1.setLastname("Gupta");
		emp1.setBirthDate((java.sql.Date) new Date());
		emp1.setCellphone("12345");
		emp1.setDepartment(department);
//		emp2.setDepartment(department);
		

		session.save(emp1);
//		session.save(emp2);
//		Query query = session.createQuery("from Employee e where e.department_id=?");
//		query.setParameter(0, 1);
//		List<Employee> list = query.list();
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}

		tx.commit();
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();
	}

}
