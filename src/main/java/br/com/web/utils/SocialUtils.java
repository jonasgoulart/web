package br.com.web.utils;

import org.brickred.socialauth.SocialAuthConfig;

public final class SocialUtils
{
	public static final String BASE_URL = "http://localhost:8080/web";
	
	public static final SocialAuthConfig SOCIAL_AUTH_CONFIG = SocialAuthConfig.getDefault();
	
	static
	{
		try{
				SOCIAL_AUTH_CONFIG.load();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	
	private SocialUtils()
	{
		
	}
}