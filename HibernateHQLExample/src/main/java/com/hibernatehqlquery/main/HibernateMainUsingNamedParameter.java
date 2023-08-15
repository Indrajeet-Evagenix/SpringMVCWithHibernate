package com.hibernatehqlquery.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernatehqlquery.model.Employee;
import com.hibernatehqlquery.util.HibernateUtil;

public class HibernateMainUsingNamedParameter {

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
		session.save(e2);
		session.save(e1);
		session.save(e);
		// Using Label
		Query query = session.createQuery("update Employee e set e.sal=:sal where e.id=:id");
		query.setParameter("sal", 9000);
		query.setParameter("id", 121);

		int i = query.executeUpdate();

		System.out.println("Data Updated Successfully and " + i + " row changes");

		// Using question Mark Symbol
		query = session.createQuery("delete from Employee e where e.id=?");

		query.setParameter(0, 100);

		i = query.executeUpdate();
		System.out.println("Data Updated Successfully and " + i + " row changes");
		tx.commit();
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();

	}

}
