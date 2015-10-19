package br.com.web.constants;

import br.com.web.utils.PropertiesUtil;

public enum MessageRequestEnum 
{
	REQUEST_SUCESS(PropertiesUtil.getMessage("message", "REQUEST_SUCESS")),
			
	ERROR(PropertiesUtil.getMessage("message", "ERROR"));
	
	public String value;
	
	MessageRequestEnum(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}