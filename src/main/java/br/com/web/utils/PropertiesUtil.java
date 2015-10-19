package br.com.web.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class PropertiesUtil 
{
	private static final Locale locale;
	
	static 
	{        
		try{
				FacesContext facesContext = FacesContext.getCurrentInstance();    
				locale = facesContext.getViewRoot().getLocale(); 
	            
	    }catch(Throwable ex) {
	    	throw new ExceptionInInitializerError(ex);
	    }
	}
	
	public static String getMessage(String properties, String key)
	{
		ResourceBundle bundle = ResourceBundle.getBundle(properties, locale);
		return bundle.getString(key);  
	}
}