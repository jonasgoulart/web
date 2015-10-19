package br.com.web.utils;

import java.security.MessageDigest;

public class EncryptionUtil 
{
	public String encrypt(String text) throws Exception
	{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(text.getBytes("UTF-8"));
			 
		StringBuilder hexString = new StringBuilder();
				
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
				
		return hexString.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		EncryptionUtil c = new EncryptionUtil();
		
		System.out.println(c.encrypt("jgm.melo@gmail.com").length());
	}
}