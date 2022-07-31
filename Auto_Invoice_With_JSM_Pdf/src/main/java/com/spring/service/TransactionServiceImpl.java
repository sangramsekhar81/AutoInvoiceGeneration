package com.spring.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.TransactionDao;
import com.spring.model.Transaction;
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Transaction> getAllTransaction() {
		return transactionDao.getAllTransaction();
	}

}
