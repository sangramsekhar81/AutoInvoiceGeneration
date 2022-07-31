package com.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.AccountHolderDetails;

@Repository
public class AccountHolderDetailsDaoImpl implements AccountHolderDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AccountHolderDetails addAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
		sessionFactory.getCurrentSession().save(accountHolderDetails);
		return accountHolderDetails;
	}

}
