package com.myapp.hibstates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
		ServiceRegistry servreg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessfac = config.buildSessionFactory(servreg);
		Session session = sessfac.openSession();
		session.beginTransaction();

		//		Laptop l = new Laptop();
		//		l.setLid(101);
		//		l.setBrand("Asus");
		//		l.setPrice(10000);
		//		session.save(l);
		//		l.setPrice(15000);
		//		session.remove(l);
		//		session.getTransaction().commit();
		//		session.detach(l);
		//		l.setPrice(25000);

		Laptop lap = session.get(Laptop.class,501);  //get() always queries the table whereas load() triggers query only if object
		System.out.println(lap);                     //is being used 
		//get() throws null when data not present and load() throws exception
		session.getTransaction().commit();
	}
}
