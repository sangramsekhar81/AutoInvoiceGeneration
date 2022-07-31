package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.OrderDao;
import com.spring.model.CustomerDetails;
import com.spring.model.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	@Transactional
	public Orders addOrders(Orders order) {
		
		CustomerDetails cust=new CustomerDetails();
		cust.setCustomerName(order.getCustomerDetails().getCustomerName());
		cust.setCustomerGstNumber(order.getCustomerDetails().getCustomerGstNumber());
		cust.setCustomerAddress(order.getCustomerDetails().getCustomerAddress());
		cust.setEmail(order.getCustomerDetails().getEmail());
		return orderDao.addOrders(order);
	}

}
