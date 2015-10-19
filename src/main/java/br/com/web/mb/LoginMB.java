package br.com.web.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.SocialAuthManager;

import br.com.web.constants.SocialAuthProviderEnum;
import br.com.web.domain.User;
import br.com.web.servlets.SocialLoginServlet;
import br.com.web.utils.SocialUtils;

@ManagedBean
@RequestScoped
public class LoginMB implements Serializable
{
	private static final long serialVersionUID = -6666588812353494010L;
	private User user;
	
	public void doLinkedinLogin()
	{
		try{
				initializeSocialFacebookLoginAndRedirect(SocialAuthProviderEnum.FACEBOOK);
		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	
	public String loggout()
	{
		try{
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();			
				return "pretty:index";
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			return "pretty:login";
		}
	}
	
	private static void initializeSocialFacebookLoginAndRedirect(SocialAuthProviderEnum provider)
	{
	    try{
	    		SocialAuthManager manager = new SocialAuthManager();
	    		manager.setSocialAuthConfig(SocialUtils.SOCIAL_AUTH_CONFIG);	    		
	    			    			    		
	    		String url = manager.getAuthenticationUrl(org.brickred.socialauth.util.Constants.FACEBOOK, SocialLoginServlet.SERVLET_URL);
	    		    			    			    		
	    		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	      
	    		((HttpServletRequest) context.getRequest()).getSession().setAttribute("authManager", manager);
	    		
	    		context.redirect(url);
	    		
	    }catch (Exception e){
	    	
	    	e.printStackTrace();
	    }
	}
	
	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}
}