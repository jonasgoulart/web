package br.com.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.web.domain.Manufacturer;
import br.com.web.domain.Product;
import br.com.web.domain.ProductType;

public class ProductDAO extends DAO<Product>
{
	@SuppressWarnings("unchecked")
	public List<Product> listAllByProductTypeAndManufacturer(ProductType productType, Manufacturer manufacturer)
	{
		try{
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Restrictions.eq("type", productType));
				criteria.add(Restrictions.eq("manufacturer", manufacturer));
				return criteria.list();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
			return null;
		}
	}
}