package com.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AccountHolderDetailsDao;
import com.spring.model.AccountHolderDetails;
import com.spring.model.CustomerDetails;

@Service
public class AccountHolderDetailsServiceImpl implements AccountHolderDetailsService {
	@Autowired
	private AccountHolderDetailsDao accountHolderDetailsDao;

	@Override
	@Transactional
	public AccountHolderDetails addAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
		
//		accountHolderDetailsDao.addAccountHolderDetails(accountHolderDetails);
//		CustomerDetails cust=new CustomerDetails();
//		cust.setCustomerName(accountHolderDetails.getCustomerDetails().getCustomerName());
//		cust.setCustomerGstNumber(accountHolderDetails.getCustomerDetails().getCustomerGstNumber());
//		cust.setCustomerAddress(accountHolderDetails.getCustomerDetails().getCustomerAddress());
//		accountHolderDetails.setCustomerDetails(cust);
		return accountHolderDetailsDao.addAccountHolderDetails(accountHolderDetails);
	}

}
