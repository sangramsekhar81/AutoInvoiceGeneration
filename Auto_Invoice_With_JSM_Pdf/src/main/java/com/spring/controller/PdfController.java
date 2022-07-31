package com.spring.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.tool.schema.spi.Exporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;
import com.spring.model.Transaction;
import com.spring.service.PdfUserGeneratorService;
import com.spring.service.TransactionService;

@RestController
public class PdfController {

	@Autowired
	private PdfUserGeneratorService pdfUserGenerator;
	
	@Autowired
	private TransactionService transactionService;

	/*
	 * @RequestMapping(value = "/pdf", method = RequestMethod.POST)
	 * 
	 * public ResponseEntity<?> pdfGenerator(int id, String customerName) throws
	 * Exception {
	 * 
	 * ResponseEntity<?> list = pdfUserGenerator.pdfGen(id,customerName);
	 * 
	 * return ResponseEntity.ok(list);
	 * 
	 * }
	 */

	
	@GetMapping("/pdf")
	public ResponseEntity<?> exportToPDF() throws Exception {
		List<Transaction> Customers = transactionService.getAllTransaction();
		
		PdfUserGeneratorService exporter = new PdfUserGeneratorService(Customers);
	
		List<Transaction> clist = transactionService.getAllTransaction();
		for(Transaction t: clist) {	
		String pdf_path ="/home/rapidsoft/Desktop/"+t.getCustomerDetails().getCustomerName()+"'s invoice.pdf";
		exporter.export(pdf_path);	
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
