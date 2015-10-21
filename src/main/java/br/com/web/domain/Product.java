package br.com.web.domain;

public class Product extends Domain
{
	private ProductType type;

	private Manufacturer manufacturer;

	private String model;

	public String getModel()
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public Manufacturer getManufacturer() 
	{
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) 
	{
		this.manufacturer = manufacturer;
	}

	public ProductType getType() 
	{
		return type;
	}

	public void setType(ProductType type) 
	{
		this.type = type;
	}
}