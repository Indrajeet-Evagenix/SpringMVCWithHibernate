package com.springhibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springhibernatedemo.model.Employee;
import com.springhibernatedemo.model.Meeting;
import com.springhibernatedemo.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		// start transaction
		Transaction tx = session.beginTransaction();

		Meeting meeting1 = new Meeting("Quaterly Sales meeting");
		Meeting meeting2 = new Meeting("Weekly Status meeting");

		Employee employee1 = new Employee("Sergey", "Brin");
		Employee employee2 = new Employee("Larry", "Page");

		employee1.getMeetings().add(meeting1);
		employee1.getMeetings().add(meeting2);
		employee2.getMeetings().add(meeting1);

		session.save(employee1);
		session.save(employee2);

		tx.commit();
		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionAnnotationFactory().close();
	}

}
