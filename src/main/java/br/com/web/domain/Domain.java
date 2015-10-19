package br.com.web.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Domain 
{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="DATE_INCLUSION", nullable=false)
	private Date dateInclusion;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDateInclusion() 
	{
		return dateInclusion;
	}

	public void setDateInclusion(Date dateInclusion) 
	{
		this.dateInclusion = dateInclusion;
	}
}