package br.com.web.services;

import br.com.web.dao.CompanyDAO;
import br.com.web.dao.UserDAO;
import br.com.web.domain.Account;
import br.com.web.domain.User;

public class AccountService 
{
	private Account account;
	
	public AccountService()
	{
		this.account = new Account();
	}
	
	public Account loadAccount(Long userId)
	{
		try{
				User user = new UserDAO().selectById(userId);
				
				if(user != null)
				{
					this.account.setUser(user);
					this.account.setCompany(new CompanyDAO().selectByUser(user));					
					return account;
				}

				return null;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			return null;
		}
	}
}