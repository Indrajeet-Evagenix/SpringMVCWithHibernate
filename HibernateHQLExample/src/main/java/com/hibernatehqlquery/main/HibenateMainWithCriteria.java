package com.hibernatehqlquery.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernatehqlquery.model.Employee;
import com.hibernatehqlquery.util.HibernateUtil;

public class HibenateMainWithCriteria {

	public static void main(String[] args) {

		Employee e2 = new Employee();
		e2.setId(124);
		e2.setName("Aniket");
		e2.setRole("Clerk");
		e2.setSal(78000);

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

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		Transaction tx = session.beginTransaction();
		session.save(e2);
		session.save(e1);
		session.save(e);
		// Use of simeple Criteria
		Criteria cr;
		cr = session.createCriteria(Employee.class);
		List<Employee> list = cr.list();
		Iterator<Employee> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-----------------------------------------");
		// Use of Criteria With Restrictions
		cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.like("name", "A%"));
		list = cr.list();
		iter = list.iterator();
		while (iter.hasNext()) {

			System.out.println(iter.next());
		}
		System.out.println("-----------------------------------------");
		// Use of Criteria with and Expression
		cr = session.createCriteria(Employee.class);
		cr.add(Expression.between("sal", 2000, 8000));
		list = cr.list();
		iter = list.iterator();
		while (iter.hasNext()) {

			System.out.println(iter.next());
		}
		System.out.println("-----------------------------------------");
		// Criteria with the use of Criterion concepts with the Restrictions with the
		// use of order
		Criteria criteria = session.createCriteria(Employee.class);
		Criterion crt = Restrictions.idEq(new Integer(124));
		crt = Restrictions.eq("sal", new Integer(7800));
		// crt=Restrictions.like("name", "a%") ;
		// crt=Restrictions.between("name", "a","n");

		criteria.add(crt);

		criteria.addOrder(Order.asc("sal"));

		list = criteria.list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------------------------------");
		// To put AND and OR in Criteria
		Criterion cr1 = Restrictions.between("sal", new Integer(7000), new Integer(90000));
		Criterion cr3 = Restrictions.eq("name", "Manasi");

		LogicalExpression expression = Restrictions.or(cr3, cr1);
		criteria.add(expression);

		List list1 = criteria.list();
		Iterator iterator1 = list1.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}

	}

}
