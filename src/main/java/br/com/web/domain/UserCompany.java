package br.com.web.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_COMPANY")
public class UserCompany extends Domain
{
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPANY")
	private Company company;
	
	public User getUser() 
	{
		return user;
	}
	
	public void setUser(User user) 
	{
		this.user = user;
	}
	
	public Company getCompany() 
	{
		return company;
	}
	
	public void setCompany(Company company) 
	{
		this.company = company;
	}
}