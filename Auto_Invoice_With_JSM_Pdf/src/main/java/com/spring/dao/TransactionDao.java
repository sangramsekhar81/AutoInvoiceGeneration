package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.Transaction;

public interface TransactionDao {

	
	public List<Transaction> getAllTransaction() ;
}
