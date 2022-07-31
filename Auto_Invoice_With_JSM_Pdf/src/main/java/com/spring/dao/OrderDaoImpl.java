package com.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Orders;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Orders addOrders(Orders order) {

	    sessionFactory.getCurrentSession().save(order);
	    return order;
	}
}
