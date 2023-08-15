package com.hibernatehqlquery.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernatehqlquery.model.Employee;
import com.hibernatehqlquery.util.HibernateUtil;

public class HibernateMainWithAggreegateFunctions {

	public static void main(String[] args) {

		Employee e2 = new Employee();
		e2.setId(124);
		e2.setName("Aniket");
		e2.setRole("Clerk");
		e2.setSal(7800);

		Employee e1 = new Employee();
		e1.setId(121);
		e1.setName("Manasi");
		e1.setRole("MD");
		e1.setSal(80222);

		Employee e = new Employee();
		e.setId(100);
		e.setName("Sam");
		e.setRole("Manager");
		e.setSal(45000);
		// Get Session
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		session.beginTransaction();
		session.save(e2);
		session.save(e1);
		session.save(e);
		// Use of Count aggregate function.
		Query q = session.createQuery("select count(distinct e.name) from Employee e");
		List<Integer> list = q.list();
		System.out.println(list);
		System.out.println("------------------------------------------------");

		// Use Sum aggregate Function
		q = session.createQuery("select sum(e.sal) from Employee e");
		list = q.list();
		System.out.println(list);
		System.out.println("------------------------------------------------");

		// Use of Avg aggregatefunction
		q = session.createQuery("select avg(e.sal) from Employee e");
		list = q.list();
		System.out.println(list);
		System.out.println("------------------------------------------------");

		// Use of Min aggregate functions
		q = session.createQuery("select min(e.sal) from Employee e");
		list = q.list();
		System.out.println(list);
		System.out.println("------------------------------------------------");

		// Use of Max aggregate function
		q = session.createQuery("select max(e.sal) from Employee e");
		list = q.list();
		System.out.println(list);
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();

	}

}
