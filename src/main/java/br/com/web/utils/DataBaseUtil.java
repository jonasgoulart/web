package br.com.web.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.web.dao.CategoryDAO;
import br.com.web.dao.ManufacturerDAO;
import br.com.web.dao.ProductDAO;
import br.com.web.dao.ProductTypeDAO;
import br.com.web.domain.Category;
import br.com.web.domain.Manufacturer;
import br.com.web.domain.Product;
import br.com.web.domain.ProductType;

public class DataBaseUtil
{
	public static void main(String[] args) throws Throwable
	{  
		HibernateUtil.createDataBase();		 
		
		populateDataBase();
		
		System.exit(0);
	}
	
	public static void populateDataBase()
	{
		Manufacturer motorola = new Manufacturer();
		motorola.setName("Motorola");
		
		Manufacturer samsung = new Manufacturer();
		samsung.setName("Samsung");
		
		Manufacturer dell = new Manufacturer();
		dell.setName("Dell");
	
		
		motorola = new ManufacturerDAO().save(motorola);
		samsung = new ManufacturerDAO().save(samsung);
		dell = new ManufacturerDAO().save(dell);
		
		
		
		Category telefonia = new Category();
		telefonia.setName("Telefonia");
		
		Category informatica = new Category();
		informatica.setName("Informática");
		
			
		telefonia = new CategoryDAO().save(telefonia);		
		informatica = new CategoryDAO().save(informatica);
	
		
				
		ProductType smartphone = new ProductType();
		smartphone.setName("Smartphone");
		smartphone.setCategory(telefonia);
		
		ProductType tablet = new ProductType();
		tablet.setName("Tablet");
		tablet.setCategory(informatica);
		
		ProductType notebook = new ProductType();
		notebook.setName("Notebook");
		notebook.setCategory(informatica);
		

		smartphone = new ProductTypeDAO().save(smartphone);
		tablet = new ProductTypeDAO().save(tablet);
		notebook = new ProductTypeDAO().save(notebook);
		
		
		
		Product notebookDellVostro = new Product();
		notebookDellVostro.setType(notebook);
		notebookDellVostro.setManufacturer(dell);
		notebookDellVostro.setModel("Vostro 3300");
		
		Product smartphoneGalaxyS6 = new Product();
		smartphoneGalaxyS6.setType(smartphone);
		smartphoneGalaxyS6.setManufacturer(samsung);
		smartphoneGalaxyS6.setModel("Galaxy S6");
		
		Product tabletGalaxyS6 = new Product();
		tabletGalaxyS6.setType(tablet);
		tabletGalaxyS6.setManufacturer(samsung);
		tabletGalaxyS6.setModel("Galaxy S6");
		
		
		List<Product> products = new ArrayList<Product>();
		products.add(notebookDellVostro);
		products.add(smartphoneGalaxyS6);
		products.add(tabletGalaxyS6);
		
		new ProductDAO().save(products);
	}
}