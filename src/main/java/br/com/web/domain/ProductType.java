package br.com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_TYPE")
public class ProductType extends Domain
{
	@Column(name="NAME", nullable=false, length=32)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY")
	private Category category;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
	}
}