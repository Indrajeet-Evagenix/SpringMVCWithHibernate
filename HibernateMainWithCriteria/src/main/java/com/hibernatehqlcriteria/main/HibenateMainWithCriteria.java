package com.hibernatehqlcriteria.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hibernatehqlcriteria.model.Employee;
import com.hibernatehqlcriteria.util.HibernateUtil;

public class HibenateMainWithCriteria {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setName("Indrajeet");
		employee.setRole("Developer");
		employee.setSal(35000);

		Employee employee1 = new Employee();
		employee1.setName("Ashish");
		employee1.setRole("Tester");
		employee1.setSal(25000);

		Employee employee2 = new Employee();
		employee2.setName("Amarjeet");
		employee2.setRole("HR");
		employee2.setSal(20000);

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();

		// Start Session

		Transaction tx = session.beginTransaction();
//		session.save(employee);
//		session.save(employee1);
//		session.save(employee2);

		Criteria criteria;
//		criteria = session.createCriteria(Employee.class);
//		List<Employee> list = criteria.list();
//		for (Employee employees : list) {
//			System.out.println(employees);
//		}

		// Use of Criteria With Restrictions

//		criteria = session.createCriteria(Employee.class);
//		criteria.add(Restrictions.like("name", "A%"));
//		List<Employee> list = criteria.list();
//		for (Employee emp : list) {
//			System.out.println(emp);
//		}

		// Use criteria with and expression
		// Shows Error
//		criteria = session.createCriteria(Employee.class);
//		criteria.add(Expression.between("sal", 21000, 36000));
//		List<Employee> list = criteria.list();
//		for (Employee emp1 : list) {
//			System.out.println(emp1);
//		}

		// Criteria with the use of criterion concept with the Restrictions with the use
		// of order

		criteria = session.createCriteria(Employee.class);
		Criterion cr=(Restrictions.idEq(new Integer(2)));
		cr=Restrictions.eq("sal", new Integer(35000));
		criteria.add(cr);
		criteria.addOrder(Order.asc("sal"));
		List<Employee> list = criteria.list();
		for (Employee emp2 : list) {
			System.out.println(emp2);
		}

		// To put AND and OR in Criteria
//		criteria = session.createCriteria(Employee.class);
//		Criterion cr1 = Restrictions.between("sal", new Integer(21000), new Integer(36000));
//		Criterion cr3 = Restrictions.eq("name", "Indrajeet");
//
//		LogicalExpression expression = Restrictions.or(cr3, cr1);
//		criteria.add(expression);
//		List<Employee> list = criteria.list();
//		for (Employee emp3 : list) {
//			System.out.println(emp3);
//		}

		tx.commit();

		HibernateUtil.getSessionAnnotationFactory().close();
	}

}
