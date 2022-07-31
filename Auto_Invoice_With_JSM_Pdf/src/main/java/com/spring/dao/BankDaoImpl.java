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

import com.spring.dto.BankDto;
import com.spring.model.Bank;

@Repository
public class BankDaoImpl implements BankDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Bank> getBank() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Bank> cq = cb.createQuery(Bank.class);
	      Root<Bank> root = cq.from(Bank.class);
	      cq.select(root);
	      Query<Bank> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public List<BankDto> getBankDto() {
		
		return null;
	}

	@Override
	public BankDto entityToDto(Bank bank) {
		BankDto bankDto=new BankDto();
		bankDto.setBankName(bank.getBankName());
		return bankDto;
	}

}
