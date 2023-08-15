package com.springhibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.springhibernate.model.Address;
import com.springhibernate.model.Contact;
import com.springhibernate.model.Employee;
import com.springhibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Contact contact = new Contact();
		contact.setId(101);
		contact.setHomeNumber("8412967583");
		contact.setSelfNumber("1234567890");

		Address ad = new Address();

		ad.setStreet("Ashok singh chawl");
		ad.setCity("Mumbai");
		ad.setState("Maharashtra");
		ad.setZipcode("401209");
		Employee e2 = new Employee();
		e2.setId(60);
		e2.setName("Aniket");
		e2.setRole("Clerk");
		e2.setAddress(ad);

		Employee e1 = new Employee();
		e1.setId(61);
		e1.setName("Manasi");
		e1.setRole("MD");
		e2.setAddress(ad);

		Employee e = new Employee();
		e.setId(62);
		e.setName("Sam");
		e.setRole("Manager");
		// Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// start transaction
		session.beginTransaction();
		// Save the Model object means insert the record in the datadbase.
//		session.save(e2);
//		session.save(e1);
//		session.save(e);
		session.save(contact);

		// To fetch the all the records.
		// using the Query object we are generating the query which will fetch the all
		// the records
//		Query query = session.createQuery("From Employee e");
//		List<Employee> list = query.list();
//		Iterator<Employee> itr = list.iterator();
//		while(itr.hasNext()){
//			System.out.println(itr.next());
//		}

		// Use of the load method to get the particular record
//		 e = (Employee) session.load(Employee.class,121); 
//		 
//		//Now the same record is we can update
//		e.setName("seed");
//		e.setRole("Manager");
//	    session.update(e); 	

		// To delete the records

//	   e1 = (Employee) session.get(Employee.class,124);

//	    session.delete(e1);
		// Commit transaction
		session.getTransaction().commit();

		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}
}
