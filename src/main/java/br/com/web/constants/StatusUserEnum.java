package br.com.web.constants;

public enum StatusUserEnum 
{
	A("Ativo"),
	I("Inativo"),
	B("Bloqueado");

	private final String value;

	private StatusUserEnum(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
	    return value;
	}
}