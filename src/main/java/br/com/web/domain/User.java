package br.com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.web.constants.AccountOriginEnum;
import br.com.web.constants.StatusUserEnum;
import br.com.web.constants.UserTypeEnum;

@Entity
@Table(name="USER")
public class User extends Domain
{
	@Column(name="NAME", nullable=false, length=32)
	private String name;
	
	@Column(name="EMAIL", nullable=false, length=64)
	private String email;
	
	@Column(name="PASSWORD", nullable=true, length=64)
	private String password;
	
	@Column(name="PHONE", nullable=true, length=11)
	private String phone;
	
	@Column(name="URL_IMAGE", nullable=true, length=500)
	private String urlImage;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COD_ORIGIN", nullable=false)
	private AccountOriginEnum origin;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COD_TYPE", nullable=false)
	private UserTypeEnum type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="COD_STATUS", nullable=false)
	private StatusUserEnum status;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getUrlImage() 
	{
		return urlImage;
	}

	public void setUrlImage(String urlImage) 
	{
		this.urlImage = urlImage;
	}

	public AccountOriginEnum getOrigin() 
	{
		return origin;
	}

	public void setOrigin(AccountOriginEnum origin) 
	{
		this.origin = origin;
	}

	public UserTypeEnum getType() 
	{
		return type;
	}

	public void setType(UserTypeEnum type) 
	{
		this.type = type;
	}

	public StatusUserEnum getStatus() 
	{
		return status;
	}

	public void setStatus(StatusUserEnum status) 
	{
		this.status = status;
	}
}