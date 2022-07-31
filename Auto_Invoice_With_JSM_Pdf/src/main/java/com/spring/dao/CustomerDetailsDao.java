package com.spring.dao;

import java.util.List;

import com.spring.dto.CustomerDetailsDto;
import com.spring.model.CustomerDetails;

public interface CustomerDetailsDao{
	
	public CustomerDetails addCustomerDetails(CustomerDetails cust);
	public CustomerDetailsDto entityToDto(CustomerDetails custDetails);
	public List<CustomerDetails> getCustomer(String customerName);
    public List<CustomerDetailsDto> getCustomerDto();
    

	
}
