package br.com.web.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.web.domain.Domain;
import br.com.web.utils.HibernateUtil;

public class DAO
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
	
	public Domain save(Domain entity)
	{
		try{
				entity.setDateInclusion(new Date());
				transaction = session.beginTransaction();
				session.saveOrUpdate(entity);
				transaction.commit(); 			
				return entity;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			if(transaction != null)
			{
				transaction.rollback();
			}
		
			return null;	
		}
	}
}