package br.com.web.constants;

import br.com.web.utils.PropertiesUtil;

public enum MessageRegisterEnum 
{
	REGISTER_SUCESS(PropertiesUtil.getMessage("message", "REGISTER_SUCESS")),
			
	ERROR(PropertiesUtil.getMessage("message", "ERROR"));
	
	public String value;
	
	MessageRegisterEnum(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}