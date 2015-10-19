package br.com.web.constants;

public enum UserTypeEnum 
{
	A("Administrador"),
	AE("Administrador Empresa"),
	C("Usuário Comum");

	private final String value;

	private UserTypeEnum(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
	    return value;
	}
}