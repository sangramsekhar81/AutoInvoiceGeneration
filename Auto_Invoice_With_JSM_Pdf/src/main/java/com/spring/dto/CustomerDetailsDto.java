package com.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsDto {
	private String customerName;
	private String customerGstNumber;
	private String customerAddress;
	private String email;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGstNumber() {
		return customerGstNumber;
	}
	public void setCustomerGstNumber(String customerGstNumber) {
		this.customerGstNumber = customerGstNumber;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
