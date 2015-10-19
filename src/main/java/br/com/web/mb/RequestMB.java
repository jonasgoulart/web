package br.com.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.web.constants.MessageRegisterEnum;
import br.com.web.constants.MessageRequestEnum;
import br.com.web.constants.MessageSearchEnum;
import br.com.web.domain.Address;
import br.com.web.domain.Request;
import br.com.web.services.AddressService;
import br.com.web.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class RequestMB 
{
	private Request request;
	private boolean displayFormRequestZipcode;
	private boolean displayFormRequestQuantity;
	private boolean displayFormRequestContact;

	public RequestMB()
	{
		this.request = new Request();
		this.displayFormRequestZipcode = true;
		this.displayFormRequestQuantity = false;
		this.displayFormRequestContact = false;
	}
	
	public String loadFormRequestQuantity()
	{
		try{				
				this.displayFormRequestZipcode = false;
				this.displayFormRequestQuantity = true;
				this.displayFormRequestContact = false;
				
				return null;
		
		}catch(Exception ex){
			
			SessionUtils.setAttribute("message", MessageSearchEnum.ERROR.getValue());
						
			return "pretty:messages"; 
		}
	}
	
	public String loadFormRequestContact()
	{
		try{				
				this.displayFormRequestZipcode = false;
				this.displayFormRequestQuantity = false;
				this.displayFormRequestContact = true;
				
				return null;
		
		}catch(Exception ex){
			
			SessionUtils.setAttribute("message", MessageSearchEnum.ERROR.getValue());
						
			return "pretty:messages"; 
		}
	}
	
	
	public void loadAddress()
	{
		try{
				if(this.request.getZipCode().length() == 9)
				{			
					Address address = new AddressService().getAddress(this.request.getZipCode());
			
					if(address != null)
					{
						this.request.setAddress(address.getLogradouro() + ", " + address.getLocalidade() + "-"+address.getUf());					
					}			
				}

		}catch(Exception ex){
			
			ex.printStackTrace();			
		}	
	}
	
	public String sendRequest()
	{
		try{
				SessionUtils.setAttribute("message", MessageRequestEnum.REQUEST_SUCESS.getValue());
			
				return "pretty:messages"; 
			
		}catch(Exception ex){
			
			SessionUtils.setAttribute("message", MessageRequestEnum.ERROR.getValue());
			
			return "pretty:messages"; 
		}
	}
	
	public Request getRequest() 
	{
		return request;
	}

	public void setRequest(Request request) 
	{
		this.request = request;
	}

	public boolean isDisplayFormRequestZipcode() 
	{
		return displayFormRequestZipcode;
	}

	public void setDisplayFormRequestZipcode(boolean displayFormRequestZipcode) 
	{
		this.displayFormRequestZipcode = displayFormRequestZipcode;
	}

	public boolean isDisplayFormRequestQuantity() 
	{
		return displayFormRequestQuantity;
	}

	public void setDisplayFormRequestQuantity(boolean displayFormRequestQuantity) 
	{
		this.displayFormRequestQuantity = displayFormRequestQuantity;
	}

	public boolean isDisplayFormRequestContact() 
	{
		return displayFormRequestContact;
	}

	public void setDisplayFormRequestContact(boolean displayFormRequestContact) 
	{
		this.displayFormRequestContact = displayFormRequestContact;
	}
}