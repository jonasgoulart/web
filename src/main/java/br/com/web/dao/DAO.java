package br.com.web.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.web.domain.Domain;
import br.com.web.utils.HibernateUtil;

public class DAO<T extends Domain>
{
	protected static Session session;
	protected static Transaction transaction;
	
	public DAO()
	{
		try{
				session = HibernateUtil.getSession();
		
		}catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	
	public T save(T domain)
	{
		try{
				domain.setDateInclusion(new Date());
				transaction = session.beginTransaction();
				session.saveOrUpdate(domain);
				transaction.commit(); 			
				return domain;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			if(transaction != null)
			{
				transaction.rollback();
			}
		
			return null;	
		}
	}
	
	public boolean save(List<T> domains)
	{
		try{
				transaction = session.beginTransaction();
				
				for(Domain domain : domains)
				{
					domain.setDateInclusion(new Date());
					session.save(domain);					
				}
				
				transaction.commit();				
				return true;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			if(transaction != null)
			{
				transaction.rollback();
			}
		
			return false;	
			
		}finally{
			
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listAll()
	{
		try{
            	Criteria criteria = session.createCriteria(getTypeClass());
            	return criteria.list(); 
		
		}catch(Exception ex){
			
			return new ArrayList<T>();	
			
		}finally{
			
			session.close();
		}
	}
	
	private Class<?> getTypeClass() 
	{
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}