package com.hibernate.test;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author JoneM
 * 生成表：将hbm生成ddl
 * hibernate 5.0之后不再支持此种生成表的写法
 */
public class ExportDBTable {
	static Session session;
	static Configuration config = null;
	static Transaction tx = null;
	public static void main(String[] args) {
		//默认读取hibernate.cfg.xml文件  
		/* Configuration cfr = new Configuration().configure("hibernate.cfg.xml");  
		 SchemaExport export =new SchemaExport(cfr);  
		 export.create(true, true);  
		 */
		 
		 try {
			 config = new Configuration().configure(new File("src/hibernate.cfg.xml"));
			 System.out.println("Creating tables...");
			 
			 SessionFactory sessionFactory = config.buildSessionFactory();
			 session = sessionFactory.openSession();
			 tx = session.beginTransaction();
			 
			 SchemaExport schemaExport = new SchemaExport(config);
			 schemaExport.create(true, true);
			 
			 System.out.println("Table  created.");
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
