package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Transaction;
import com.spring.service.EmailService;
import com.spring.service.PdfUserGeneratorService;
import com.spring.service.TransactionService;

@RestController
@Import(PdfController.class)
public class EmailController {

	@Autowired
	private PdfUserGeneratorService pdfUserGenerator;

	@Autowired
	private PdfController pdfController;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendEmail")
//	@Scheduled(fixedDelay = 1000)
//	@Scheduled(cron = "0 */5 * * * *")
//	@Scheduled(cron = "0 00 10 1 * *")  // Run at 10:00 on 1Day day of Every month
	public ResponseEntity<?> sendEmail() {

//		pdfController.pdfGenerator();

		try {

			List<Transaction> list = transactionService.getAllTransaction();

			for (Transaction i : list) {

				String pdfPath = "/home/rapidsoft/Desktop/" + i.getCustomerDetails().getCustomerName() + "-"
						+ i.getProductDetails().getProductName() + ".pdf";

				  pdfController.exportToPDF();

				emailService.sendEmail(i.getCustomerDetails().getEmail(), pdfPath);

			}

//			emailService.sendEmail(request.getToEmail(), request.getSubject(), request.getBody(), request.getPdfPath());

//		this.emailService.sendEmail(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Email Sent Sucessfully.....");
	}

	/*----------------------------------------------------------------------------------------------------------------------------------*/

	/* Code Written Bellow is Working */

	/*-------------------------------------------------*/

	@PostMapping("/send/{toEmail}/{subject}/{body}/{pdfPath}")
	public ResponseEntity<?> send(@PathVariable String toEmail, @PathVariable String subject, @PathVariable String body,
			@PathVariable String pdfPath) {

		emailService.sendEmail(toEmail, pdfPath);

		return ResponseEntity.ok("Email Sent Sucessfully.....");

	}

	@PostMapping("/sending")
	public ResponseEntity<?> sending(@RequestParam String toEmail, @RequestParam String subject,
			@RequestParam String body, @RequestParam String pdfPath) {

		emailService.sendEmail(toEmail, pdfPath);

		return ResponseEntity.ok("Email Sent Sucessfully.....");

	}

}
