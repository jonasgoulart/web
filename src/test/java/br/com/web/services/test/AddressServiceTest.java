package br.com.web.services.test;

import br.com.web.services.AddressService;

public class AddressServiceTest 
{
	public static void main(String[] args) 
	{
		System.out.println(new AddressService().getAddress("01333021").getBairro());
	}
}