package br.com.web.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.web.domain.Address;
import br.com.web.utils.StringUtil;

public class AddressService 
{	
	private static String URL_DADOS_ENDERECO_VIA_CEP = "http://viacep.com.br/ws/CEP_ORIGEM/xml/";
	private static String URL_DADOS_ENDERECO_DISTANCIA = "http://maps.googleapis.com/maps/api/distancematrix/xml?origins=CEP_ORIGEM+UF_ORIGEM+Brazil&destinations=CEP_DESTINO+UF_DESTINO+Brazil&mode=CAR&language=PT&sensor=false";
	private String xmlRetorno = "";
	
	public Address getAddress(String zipCode)
	{
		try{
				URL url = new URL(URL_DADOS_ENDERECO_VIA_CEP.replace("CEP_ORIGEM", zipCode));
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 
				String line = null;
	 
				while((line = in.readLine()) != null)
				{
					xmlRetorno = xmlRetorno + line;
				}
	 
				in.close();
				urlConnection.disconnect();
		
		
				XStream xstream = new XStream(new DomDriver("UTF-8")); 
				xstream.alias("xmlcep", Address.class);
			
				Address address = (Address) xstream.fromXML(xmlRetorno);
			
				StringUtil stringUtil = new StringUtil();
			
				address.setLogradouro(stringUtil.clear(address.getLogradouro()));
				address.setLocalidade(stringUtil.clear(address.getLocalidade()));
				address.setBairro(stringUtil.clear(address.getBairro()));
			
				return address;
				
		} catch(Exception ex){
			ex.printStackTrace();
			return null;
			
		} catch(Throwable throwable){
			throwable.printStackTrace();
			return null;
	
		}finally{
			xmlRetorno = "";
		}
	}
	
	public String getDistance(Address origem, Address destino)
	{
		try{			
				URL url = new URL(URL_DADOS_ENDERECO_DISTANCIA.replace("CEP_ORIGEM", origem.getCep()).replace("UF_ORIGEM", origem.getUf()).replace("CEP_DESTINO", destino.getCep()).replace("UF_DESTINO", destino.getUf()));				
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
 
				String line = null;
 
				while((line = in.readLine()) != null)
				{
					xmlRetorno = xmlRetorno + line;
				}
				
				xmlRetorno = xmlRetorno.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
				xmlRetorno = xmlRetorno.replaceAll("<DistanceMatrixResponse>", "");
				xmlRetorno = xmlRetorno.replaceAll("</DistanceMatrixResponse>", "");
				xmlRetorno = xmlRetorno.replaceAll("<status>.*?</status>", "");
				xmlRetorno = xmlRetorno.replaceAll("<origin_address>.*?</origin_address>", "");
				xmlRetorno = xmlRetorno.replaceAll("<destination_address>.*?</destination_address>", "");
				xmlRetorno = xmlRetorno.replaceAll("<row>", "");
				xmlRetorno = xmlRetorno.replaceAll("</row>", "");
				xmlRetorno = xmlRetorno.replaceAll("<element>", "");
				xmlRetorno = xmlRetorno.replaceAll("</element>", "");
				xmlRetorno = xmlRetorno.replaceAll("<duration>.*?</duration>", "");
				xmlRetorno = xmlRetorno.replaceAll("<distance>", "");
				xmlRetorno = xmlRetorno.replaceAll("</distance>", "");
				xmlRetorno = xmlRetorno.replaceAll("<text>.*?</text>", "");
				xmlRetorno = xmlRetorno.replaceAll("<value>", "");
				xmlRetorno = xmlRetorno.replaceAll("</value>", "");
				
				in.close();
				urlConnection.disconnect();
				
				return xmlRetorno.trim();
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
			
		}finally{
			xmlRetorno = "";
		}
	}
}