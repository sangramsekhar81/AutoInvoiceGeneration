package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomerDetailsDao;
import com.spring.dto.CustomerDetailsDto;
import com.spring.model.CustomerDetails;


public interface CustomerDetailsService {

	public CustomerDetails save(CustomerDetails customerDetails);
	public List<CustomerDetailsDto> getCustomerDto(String customerName);
	CustomerDetailsDto entityToDto(CustomerDetails custDetails);
	
	

}
