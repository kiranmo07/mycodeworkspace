package com.myproject.hibernatequery;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		//		Random r = new Random();
		//		for(int i=1;i<=50;i++){
		//			Student s = new Student();
		//			s.setRollno(i);
		//			s.setName("Name" + i);
		//			s.setMarks(r.nextInt(100));
		//			sess.save(s);
		//		}
		//		sess.getTransaction().commit();
		//		sess.close();
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry srcreg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionfac = config.buildSessionFactory(srcreg);
		Session sess = sessionfac.openSession();
		sess.beginTransaction();

		//		Query q = sess.createQuery("from Student where rollno>35");
		//		List<Student> students = q.list();
		//		for(Student st: students){
		//			System.out.println(st);
		//		}

		//		Query q = sess.createQuery("from Student where rollno=7");
		//		Student s = (Student)q.uniqueResult();
		//		System.out.println(s);

		//		Query q = sess.createQuery("select rollno,name,marks from Student where rollno=7");
		//		Object[] students = (Object[])q.uniqueResult();
		//		for(Object s : students)
		//		System.out.println(s);

		//		Query q = sess.createQuery("select rollno,name,marks from Student s where s.marks>75");
		//		List<Object[]> students = (List<Object[]>)q.list();
		//		for(Object[] s : students)
		//		System.out.println(s[0]+" : "+s[1]+" : "+s[2]);

		//		int b=75;
		//		Query q = sess.createQuery("select sum(marks) from Student s where s.marks>:b");
		//		q.setParameter("b",b);
		//		Long marks = (Long)q.uniqueResult();
		//		System.out.println(marks);

		//Native Query
		//		SQLQuery sql = sess.createSQLQuery("select * from Student where rollno>35");
		//		sql.addEntity(Student.class);
		//		List<Student> students = sql.list();
		//		for(Student student : students){
		//			System.out.println(student);
		//		}

		//Native Query
		SQLQuery sql = sess.createSQLQuery("select rollno,name,marks from Student where rollno>35");
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List students = sql.list();
		for(Object student : students){
			Map m = (Map)student;
			System.out.println(m.get("name")+" : "+m.get("rollno")+" : "+m.get("marks"));
		}
	} 
}


