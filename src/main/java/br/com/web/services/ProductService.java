package br.com.web.services;

import java.util.List;

import br.com.web.dao.ManufacturerDAO;
import br.com.web.dao.ProductDAO;
import br.com.web.dao.ProductTypeDAO;
import br.com.web.domain.Manufacturer;
import br.com.web.domain.Product;
import br.com.web.domain.ProductType;

public class ProductService 
{
	public Product identifyProduct(String describe)
	{
		try{
				Product product = new Product();
			
				/* Identificar o tipo */
				List<ProductType> types = new ProductTypeDAO().listAll();
				
				for(ProductType type : types)
				{
					if(describe.toLowerCase().contains(type.getName().toLowerCase()))
					{
						System.out.println("ProductType: "+type.getName());
						product.setType(type);
						break;
					}
				}
			
				/* Identificar a marca */
				List<Manufacturer> manufacturers = new ManufacturerDAO().listAll();
				
				for(Manufacturer manufacturer : manufacturers)
				{
					if(describe.toLowerCase().contains(manufacturer.getName().toLowerCase()))
					{
						System.out.println("Manufacturer: "+manufacturer.getName());
						product.setManufacturer(manufacturer);;
						break;
					}
				}
				
			
				/* Identificar o modelo */
				List<Product> products = new ProductDAO().listAllByProductTypeAndManufacturer(product.getType(), product.getManufacturer());
			
				for(Product p : products)
				{
					if(describe.toLowerCase().contains(p.getModel().toLowerCase()))
					{
						System.out.println("Model: "+p.getModel());
						product = p;
						return product;
					}
				}
				
				return null;
			
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			return null;
		}
	}
}
