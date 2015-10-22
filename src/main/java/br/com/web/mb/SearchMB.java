package br.com.web.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.web.constants.MessageSearchEnum;
import br.com.web.domain.Product;
import br.com.web.services.ProductService;
import br.com.web.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class SearchMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String describe;
	
	public String search()
	{
		try{	
				Product product = new ProductService().identifyProduct(describe);
			
				if(product != null)
				{
					SessionUtils.setAttribute("product", product);
					
					return "pretty:data-request";
				}
				
				SessionUtils.removeAttribute("product");
				
				return "pretty:index";
			
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