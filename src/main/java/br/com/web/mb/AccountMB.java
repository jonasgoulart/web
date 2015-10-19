package br.com.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.web.domain.Account;
import br.com.web.services.AccountService;

@ManagedBean
@ViewScoped
public class AccountMB 
{
	private Account account;
	private boolean companyData;
	
	public AccountMB()
	{
		this.companyData = false;
	}
	
	public void loadAccount()
	{
		this.account = new AccountService().loadAccount(null);
	}

	public void fillCompanyData()
	{
		try{
				this.companyData = true;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	
	public void fillUserData()
	{
		try{
				this.companyData = false;
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	
	public Account getAccount() 
	{
		return account;
	}

	public void setAccount(Account account) 
	{
		this.account = account;
	}

	public boolean isCompanyData() 
	{
		return companyData;
	}

	public void setCompanyData(boolean companyData) 
	{
		this.companyData = companyData;
	}
}