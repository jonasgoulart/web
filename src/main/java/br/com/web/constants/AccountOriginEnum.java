package br.com.web.constants;

public enum AccountOriginEnum 
{
	FACEBOOK("facebook"), 
	SITE("linkedin");

	private final String value;

	private AccountOriginEnum(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
	    return value;
	}
}