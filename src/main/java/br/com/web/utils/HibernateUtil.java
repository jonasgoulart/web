package br.com.web.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

@SuppressWarnings("deprecation")
public class HibernateUtil 
{
	private static final SessionFactory sessionFactory;
	    
	static 
	{        
		try{
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	            
	    }catch(Throwable ex) {
	    	throw new ExceptionInInitializerError(ex);
	    }
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	
	public static Session getSession() throws Throwable
	{
		return getSessionFactory().openSession();
	}
	
	public static Session getCurrentSession() throws Throwable
	{
		return getSessionFactory().getCurrentSession();
	}
	
	public static void closeSession(Session session) throws Throwable
	{
		session.close();
	}
	
	public static void createDataBase() throws Throwable
	{
		try{
				AnnotationConfiguration conf = new AnnotationConfiguration();  
				conf.configure();
				SchemaExport se = new SchemaExport(conf);  
				se.drop(true, true);
				se.create(true, true);
			
		}catch(Throwable ex){
			ex.printStackTrace();
		}
	}
}