package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDetailsDao;
import com.spring.model.CustomerDetails;
import com.spring.model.ProductDetails;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	private ProductDetailsDao productDetailsDao;

	@Override
	@Transactional
	public ProductDetails save(ProductDetails productDetails) {
//		CustomerDetails cust=new CustomerDetails();
//		cust.setCustomerName(productDetails.getCustomerDetails().getCustomerName());
//		cust.setCustomerGstNumber(productDetails.getCustomerDetails().getCustomerGstNumber());
//		cust.setCustomerAddress(productDetails.getCustomerDetails().getCustomerAddress());
//		cust.setEmail(productDetails.getCustomerDetails().getEmail());
//		productDetails.setCustomerDetails(cust);
//		
		return productDetailsDao.addProductDetails(productDetails);
	}

}
