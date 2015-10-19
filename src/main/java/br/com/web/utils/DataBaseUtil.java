package br.com.web.utils;

public class DataBaseUtil
{
	public static void main(String[] args) throws Throwable
	{  
		HibernateUtil.createDataBase();		 
		System.exit(0);
	}
}