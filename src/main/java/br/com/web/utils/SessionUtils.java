package br.com.web.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtils 
{
	private static final HttpSession session;
	
	static 
	{ 
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public static void setAttribute(String name, String value)
	{
		session.setAttribute(name, value);
	}
	
	public static void removeAttribute(String name)
	{
		session.removeAttribute(name);
	}
}