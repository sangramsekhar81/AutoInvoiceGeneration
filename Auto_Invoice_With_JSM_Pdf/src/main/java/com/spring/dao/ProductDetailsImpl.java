package com.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.ProductDetails;

@Repository
public class ProductDetailsImpl implements ProductDetailsDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public ProductDetails addProductDetails(ProductDetails product) {
		
	  sessionFactory.getCurrentSession().save(product);
	  return product;
	}

}
