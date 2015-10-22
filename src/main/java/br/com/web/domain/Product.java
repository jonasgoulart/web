package br.com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product extends Domain
{
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCT_TYPE")
	private ProductType type;

	@ManyToOne
	@JoinColumn(name = "ID_MANUFACTURER")
	private Manufacturer manufacturer;

	@Column(name="DESC_MODEL", nullable=false, length=32)
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