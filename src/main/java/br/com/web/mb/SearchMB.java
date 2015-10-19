package br.com.web.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.web.constants.MessageSearchEnum;
import br.com.web.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class SearchMB 
{
	private String describe;
	
	public String search()
	{
		try{				
				SessionUtils.setAttribute("describe", describe);
								
				return "pretty:data-request";
			
		}catch(Exception ex){
						
			SessionUtils.setAttribute("message", MessageSearchEnum.ERROR.getValue());
			
			SessionUtils.removeAttribute("describe");			
			
			return "pretty:messages"; 
		}
	}

	public String getDescribe() 
	{
		return describe;
	}

	public void setDescribe(String describe) 
	{
		this.describe = describe;
	}
}