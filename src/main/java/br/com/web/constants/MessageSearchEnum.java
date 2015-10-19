package br.com.web.constants;

import br.com.web.utils.PropertiesUtil;

public enum MessageSearchEnum 
{
	SEARCH_NOT_RESULT(PropertiesUtil.getMessage("message", "SEARCH_NOT_RESULT")),
			
	ERROR(PropertiesUtil.getMessage("message", "ERROR"));
	
	public String value;
	
	MessageSearchEnum(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}