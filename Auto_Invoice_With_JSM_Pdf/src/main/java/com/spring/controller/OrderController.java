package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Orders;
import com.spring.service.OrderService;

@RestController
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orderAdd")
	  @ResponseBody
	   public Orders save(@RequestBody Orders order) {
	      Orders orders=orderService.addOrders(order);
	      return orders;
	     
	   }

}
