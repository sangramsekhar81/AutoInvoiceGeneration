package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CustomerDetailsDao;
import com.spring.dao.ProductDetailsDao;
import com.spring.dto.CustomerDetailsDto;
import com.spring.model.CustomerDetails;
import com.spring.model.ProductDetails;

@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	
	@Autowired
	private CustomerDetailsDao customerDetailsDao;
	
	@Autowired
	private ProductDetailsDao productDetailsDao;

	@Override
	@Transactional
	public CustomerDetails save(CustomerDetails customerDetails) {
		
		List<ProductDetails> productList=new ArrayList<>();
		ProductDetails prod=new ProductDetails();
		prod.setCustomerDetails(customerDetails);
		productList.add(prod);
		return customerDetailsDao.addCustomerDetails(customerDetails);
		
	}
	
	@Override
	@Transactional
	public CustomerDetailsDto entityToDto(CustomerDetails custDetails){
		
		CustomerDetailsDto dto = new CustomerDetailsDto();
		dto.setCustomerAddress(custDetails.getCustomerAddress());
		dto.setCustomerName(custDetails.getCustomerName());
		dto.setCustomerGstNumber(custDetails.getCustomerGstNumber());
		dto.setEmail(custDetails.getEmail());
		return dto;
	}
	

	@Override
	 public List<CustomerDetailsDto> getCustomerDto(String customerName){
		return customerDetailsDao.getCustomer(customerName).stream().map(this::entityToDto).collect(Collectors.toList());
	}
	

}
