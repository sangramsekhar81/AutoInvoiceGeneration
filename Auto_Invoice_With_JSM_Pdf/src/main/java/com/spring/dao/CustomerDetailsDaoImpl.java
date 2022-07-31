package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.spring.dto.CustomerDetailsDto;
import com.spring.model.CustomerDetails;

@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		  this.sessionFactory = sessionFactory;
		 }
	@Override
	public CustomerDetails addCustomerDetails(CustomerDetails cust) {

		sessionFactory.getCurrentSession().save(cust);
		return cust;
	}
	@Override
	public List<CustomerDetails> getCustomer(String customerName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<CustomerDetails> query = session.createQuery("from CustomerDetails where customerName =: customerName");
		query.setParameter("customerName", customerName);
		return query.getResultList();
	}
	@Override
	public List<CustomerDetailsDto> getCustomerDto() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CustomerDetailsDto entityToDto(CustomerDetails custDetails) {
		CustomerDetailsDto dto = new CustomerDetailsDto();
		dto.setCustomerAddress(custDetails.getCustomerAddress());
		dto.setCustomerName(custDetails.getCustomerName());
		dto.setCustomerGstNumber(custDetails.getCustomerGstNumber());
		dto.setEmail(custDetails.getEmail());
		return dto;
	}
	

	
  

}
