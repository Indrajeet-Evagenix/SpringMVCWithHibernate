package com.springhibernate.main;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.springhibernate.model.Address;
import com.springhibernate.model.Employee;
import com.springhibernate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Address ad = new Address();
	
		ad.setStreet("Ashok singh chawl");
		ad.setProvince("Santosh Bbuvan");
		ad.setCountry("India");
		ad.setZip("401209");

		Employee e2 = new Employee();

		e2.setName("Aniket");
		e2.setRole("Clerk");
		e2.setInsertTime(new Date());
		e2.setAddress(ad);

		Employee e1 = new Employee();

		e1.setName("Manasi");
		e1.setRole("MD");
		e1.setInsertTime(new Date());
		e1.setAddress(ad);

		Employee e = new Employee();

		e.setName("Sam");
		e.setRole("Manager");
		e.setInsertTime(new Date());
		// Get Session
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		session.beginTransaction();
		// Save the Model object means insert the record in the datadbase.
		session.save(e2);
		session.save(e1);
		session.save(e);

		// To fetch the all the records.
		// using the Query object we are generating the query which will fetch the all
		// the records
//		Query query = session.createQuery("From Employee e");
//		List<Employee> list = query.list();
//		Iterator<Employee> itr = list.iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}

		// Use of the load method to get the particular record e = (Employee)
//		  session.load(Employee.class,18);
////		  
////		  //Now the same record is we can update e.setName("Sam");
//		  e.setRole("HR"); session.update(e);

		// To delete the records

//		  e1 = (Employee) session.get(Employee.class,17);
//		  
//		  session.delete(e1);
		// Commit transaction
		session.getTransaction().commit();

		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();
	}
}
