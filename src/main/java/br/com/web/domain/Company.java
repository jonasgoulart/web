package br.com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company extends Domain
{
	@Column(name="NAME", nullable=false, length=32)
	private String name;
	
	@Column(name="CNPJ", nullable=false, length=14)
	private String cnpj;
	
	@Column(name="ZIP_CODE", nullable=false, length=8)
	private String zipCode;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getCnpj() 
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}

	public String getZipCode() 
	{
		return zipCode;
	}

	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}
}