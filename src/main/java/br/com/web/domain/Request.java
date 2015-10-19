package br.com.web.domain;

public class Request
{
	private String searchDescribe;
	private Integer quantity;
	private String zipCode;
	private String address;
	
	public String getSearchDescribe()
	{
		return searchDescribe;
	}
	
	public void setSearchDescribe(String searchDescribe) 
	{
		this.searchDescribe = searchDescribe;
	}
	
	public Integer getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}
	
	public String getZipCode() 
	{
		return zipCode;
	}
	
	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}
}