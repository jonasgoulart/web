package br.com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MANUFACTURER")
public class Manufacturer extends Domain
{
	@Column(name="NAME", nullable=false, length=32)
	private String name;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}