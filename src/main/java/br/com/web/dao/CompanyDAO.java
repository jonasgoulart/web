package br.com.web.dao;

import br.com.web.domain.Company;
import br.com.web.domain.User;

public class CompanyDAO extends DAO
{
	public Company selectByUser(User user)
	{
		Company company = new Company();
		company.setName("Submarino Comércio Ltda");
		company.setCnpj("11.111.111/1111-11");
		company.setZipCode("01333-021");
		return company;
	}
}