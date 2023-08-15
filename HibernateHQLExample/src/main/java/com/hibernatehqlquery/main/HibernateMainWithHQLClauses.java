package com.hibernatehqlquery.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernatehqlquery.model.Employee;
import com.hibernatehqlquery.util.HibernateUtil;

public class HibernateMainWithHQLClauses {

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
		Transaction tx = session.beginTransaction();
		// Save the Model object means insert the record in the datadbase.
		session.save(e2);
		session.save(e1);
		session.save(e);

		// To fetch the all the records.
		// using the Query object we are generating the query which will fetch the all
		// the records
		// Different Clauses
		// From clause
		Query query = session.createQuery("From Employee ");
		List<Employee> list = query.list();
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Data Retrived");
		// As Clause(used to give alias specifically when query is long
		query = session.createQuery("From Employee e ");

		// Select Clause
		System.out.println("Use of Select Clause");
		query = session.createQuery("select e.id,e.name from Employee e");
		list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			System.out.println("Employee id : " + o[0] + "\tEmployee Name : " + o[1]);

		}
		System.out.println("------------------------------------------------");
		// where Clause
		System.out.println("Use of where clause");
		query = session.createQuery("from Employee e where e.id<124");
		list = query.list();
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("------------------------------------------------");
		// where Clause+Order By clause
		query = session.createQuery("from Employee e where e.id>100 ORDER BY e.sal DESC");
		list = query.list();
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
		System.out.println("------------------------------------------------");
		// Group by clause
		query = session.createQuery("select sum(e.sal),e.name from Employee e GROUP BY e.name");
		list = query.list();
		it = list.iterator();
		while (it.hasNext()) {
			Object o[] = (Object[]) it.next();

			System.out.println("Employee sal : " + o[0] + "\tEmployee Name : " + o[1]);

		}
		System.out.println("------------------------------------------------");

		tx.commit();

		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();
	}

}
