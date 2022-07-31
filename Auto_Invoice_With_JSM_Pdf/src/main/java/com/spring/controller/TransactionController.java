package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Transaction;
import com.spring.service.TransactionService;

@RestController
@CrossOrigin("*")
public class TransactionController {

	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> findAllTransaction(){
	List<Transaction> list  = transactionService.getAllTransaction();
	if(list.size()==0) {
	return ResponseEntity.notFound().build();	
	}
	return new ResponseEntity<List<Transaction>>(list,HttpStatus.OK);
   }
 }
