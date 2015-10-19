package br.com.web.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class StringUtil
{
	private Map<String, String> caracteres = new HashMap<String, String>();
	private Map<String, String> letras = new HashMap<String, String>();
	
	public StringUtil()
	{
		caracteres.put("Ã£", "ã");
		caracteres.put("Ã³", "ó");
		caracteres.put("Ã©", "é");
		caracteres.put("Ã­", "í");
		caracteres.put("Ã‚", "Â");
			
		letras.put("á", "a");
		letras.put("ã", "a");
		letras.put("é", "e");
		letras.put("ê", "e");
		letras.put("ú", "u");
		letras.put("ã,", "â");
	}
	
	public String clear(String text) throws Exception
	{
		for(Iterator<String> iterator = caracteres.keySet().iterator() ; iterator.hasNext();)
		{
			String chave = iterator.next();
			
			if(text.contains(chave)){
				return text.replace(chave, caracteres.get(chave));
			}
		}
		
		return text;
	}
	
	public String format(String text) throws Exception
	{		
		for(Iterator<String> iterator = letras.keySet().iterator() ; iterator.hasNext();)
		{
			String chave = iterator.next();
			
			if(text.contains(chave)){
				return text.replace(chave, letras.get(chave));
			}
		}
		
		return text;
	}
	
	public String gerarChave()
	{
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();  
	}
	
	public float checkSimilarity(String sString1, String sString2) throws Exception {

        // Se as strings t�m tamanho distinto, obt�m a similaridade de todas as
        // combina��es em que tantos caracteres quanto a diferen�a entre elas s�o
        // inseridos na string de menor tamanho. Retorna a similaridade m�xima
        // entre todas as combina��es, descontando um percentual que representa
        // a diferen�a em n�mero de caracteres.
        if(sString1.length() != sString2.length()) {
            int iDiff = Math.abs(sString1.length() - sString2.length());
            int iLen = Math.max(sString1.length(), sString2.length());
            String sBigger, sSmaller, sAux;

            if(iLen == sString1.length()) {
                sBigger = sString1;
                sSmaller = sString2;
            }
            else {
                sBigger = sString2;
                sSmaller = sString1;
            }

            float fSim, fMaxSimilarity = Float.MIN_VALUE;
            for(int i = 0; i <= sSmaller.length(); i++) {
                sAux = sSmaller.substring(0, i) + sBigger.substring(i, i+iDiff) + sSmaller.substring(i);
                fSim = checkSimilaritySameSize(sBigger,  sAux);
                if(fSim > fMaxSimilarity)
                    fMaxSimilarity = fSim;
            }
            return fMaxSimilarity - (1f * iDiff) / iLen;

        // Se as strings t�m o mesmo tamanho, simplesmente compara-as caractere
        // a caractere. A similaridade adv�m das diferen�as em cada posi��o.
        } else
            return checkSimilaritySameSize(sString1, sString2);
    }
	
	protected static float checkSimilaritySameSize(String sString1, String sString2) throws Exception {

        if(sString1.length() != sString2.length())
            throw new Exception("Strings devem ter o mesmo tamanho!");

        int iLen = sString1.length();
        int iDiffs = 0;

        // Conta as diferen�as entre as strings
        for(int i = 0; i < iLen; i++)
            if(sString1.charAt(i) != sString2.charAt(i))
                iDiffs++;

        // Calcula um percentual entre 0 e 1, sendo 0 completamente diferente e
        // 1 completamente igual
        return 1f - (float) iDiffs / iLen;
    }
}