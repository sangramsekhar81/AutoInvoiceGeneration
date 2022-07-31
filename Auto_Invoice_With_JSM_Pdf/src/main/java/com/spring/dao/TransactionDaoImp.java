package com.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Transaction;
import com.spring.model.Transaction;

@Repository
public class TransactionDaoImp implements TransactionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Transaction> getAllTransaction() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
	      Root<Transaction> root = cq.from(Transaction.class);
	      cq.select(root);
	      Query<Transaction> query = session.createQuery(cq);
	      return query.getResultList();
	}

}
