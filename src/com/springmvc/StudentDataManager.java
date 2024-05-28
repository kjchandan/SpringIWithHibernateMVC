package com.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class StudentDataManager {
	int id;
	String name, email, sem , marks;
	Session session;
	
	void connect() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); //connects to cfg
	    ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
	    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());       		    		 
	    session =sessionFactory.openSession();	
	    System.out.println("Connected to Pf....");
	}
	
	void addStudent(int id, String name, String email, String sem , String marks ) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.sem = sem;
		this.marks = marks;
		
		StudentEntity s= new StudentEntity(id, name, email, sem, marks);
		Transaction t = session.beginTransaction();
		session.save(s);
		t.commit();
		
	}

	
	
}
