package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.AccountHolderDetailsDao;
import com.spring.dto.CustomerDetailsDto;
import com.spring.model.AccountHolderDetails;
import com.spring.model.CustomerDetails;
import com.spring.model.ProductDetails;
import com.spring.service.AccountHolderDetailsService;
import com.spring.service.CustomerDetailsService;
import com.spring.service.ProductDetailsService;

@RestController
@CrossOrigin("*")
public class CustomerDetailsController {
	
	 
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private AccountHolderDetailsService accountHolderDetailsService;
	
//	@Autowired
//	private AccountHolderDetailsDao accountHolderDetailsDao;

	  @PostMapping("/customerAdd")
	  @ResponseBody
	   public CustomerDetails save(@RequestBody CustomerDetails cust) {
	      CustomerDetails customerDetails=customerDetailsService.save(cust);
	      return customerDetails;
	     
	   }
	  @PostMapping("/accountHolderAdd")
	  @ResponseBody
	   public AccountHolderDetails save(@RequestBody AccountHolderDetails accountHolderDetails) {
	      AccountHolderDetails accountHolder=accountHolderDetailsService.addAccountHolderDetails(accountHolderDetails);
	   //   AccountHolderDetails accountHolder=accountHolderDetailsDao.addAccountHolderDetails(accountHolderDetails);
		  return accountHolder;
	     
	   }
	  @GetMapping("/customer/search")
		public ResponseEntity<List<CustomerDetailsDto>> findByName(@RequestParam("customerName") String customerName){
			
			List<CustomerDetailsDto> customer = customerDetailsService.getCustomerDto(customerName);
			return ResponseEntity.ok().body(customer);
			
		}
		
}

