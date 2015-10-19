package br.com.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.web.constants.MessageRegisterEnum;
import br.com.web.domain.ContactPartner;
import br.com.web.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class RegisterMB 
{
	private ContactPartner contact;
	
	public RegisterMB()
	{
		this.contact = new ContactPartner();
	}
	
	public String preRegister()
	{
		try{
				SessionUtils.setAttribute("message", MessageRegisterEnum.REGISTER_SUCESS.getValue());
			
				return "pretty:messages"; 
			
		}catch(Exception ex){
			
			SessionUtils.setAttribute("message", MessageRegisterEnum.ERROR.getValue());
			
			return "pretty:messages"; 
		}
	}

	public ContactPartner getContact() 
	{
		return contact;
	}

	public void setContact(ContactPartner contact) 
	{
		this.contact = contact;
	}
}