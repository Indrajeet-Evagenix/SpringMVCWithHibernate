package com.springhibernatedemo.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springhibernatedemo.model.PermanentEmployee;
import com.springhibernatedemo.model.TemporaryEmployee;
import com.springhibernatedemo.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		Transaction tx = session.beginTransaction();

		// Creating the object of two Permanent Employees
		PermanentEmployee p1 = new PermanentEmployee();
//		p1.setId(1011);
		p1.setName("S N Rao");
		p1.setSal(25000);
		p1.setDesignation("Chemist");
		p1.setDepartment("Drugs");

		PermanentEmployee p2 = new PermanentEmployee();
//		p2.setId(1014);
		p2.setName("Sridhar");
		p2.setDesignation("Foreman");
		p2.setDepartment("Chemicals");

		// Creating the object of two Temporary Employees
		TemporaryEmployee t1 = new TemporaryEmployee();
//		t1.setId(102);
		t1.setName("Jyostna");
		t1.setWorkingDays((short) 28);
		t1.setContractorName("Raju");

		TemporaryEmployee t2 = new TemporaryEmployee();
		t2.setId(103);
		t2.setName("Jyothi");
		t2.setWorkingDays((short) 22);
		t2.setContractorName("Pratap");

		session.save(p1);
		session.save(p2);
		session.save(t1);
		session.save(t2);

		Query q = session.createQuery("FROM PermanentEmployee");
		List<PermanentEmployee> myList = q.list();
		for (PermanentEmployee p : myList) {
			System.out
					.println(p1.getId() + ", " + p1.getName() + ", " + p1.getDesignation() + ", " + p1.getDepartment());
		}

		Query q1 = session.createQuery("FROM TemporaryEmployee");
		List<TemporaryEmployee> yourList = q1.list();
		for (TemporaryEmployee t : yourList) {
			System.out.println(
					t1.getId() + ", " + t1.getName() + ", " + t1.getWorkingDays() + ", " + t1.getContractorName());
		}

		tx.commit();
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();

	}

}
