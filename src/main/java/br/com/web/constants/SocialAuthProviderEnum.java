package br.com.web.constants;

public enum SocialAuthProviderEnum 
{
	FACEBOOK("facebook"), 
	LINKED_IN("linkedin");

	private final String provider;

	private SocialAuthProviderEnum(String provider)
	{
		this.provider = provider;
	}

	@Override
	public String toString()
	{
	    return provider;
	}
}