package com.hibernate.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author JoneM
 *
 */
public class AddData {

	static Session session;
	static Configuration config = null;
	static Transaction tx = null;
	public static void main(String[] args) {
		 try {
			 config = new Configuration().configure();
			 SessionFactory sessionFactory = config.buildSessionFactory();
			 session = sessionFactory.openSession();
			 tx = session.beginTransaction();
			 User user = new User();  
			user.setUsername("jone");  
			user.setPassword("pwd");  
			user.setCreateTime(new Date());  
			user.setExpireTime(new Date());  

			session.save(user);
			tx.commit();
		 } catch (HibernateException e) {
			 e.printStackTrace();
			 try {
				 if (null != tx) {
					 tx.rollback();
				 }
			 } catch (HibernateException e1) {
				 e1.printStackTrace();
			 }
		 } finally { 
			 System.out.println("finally.............!!!!");
			  if(null != session){  
   	                if(session.isOpen()){  
   	                    //关闭session  
  	                    session.close();  
   	                }  
			  }
		 }
	}
}
