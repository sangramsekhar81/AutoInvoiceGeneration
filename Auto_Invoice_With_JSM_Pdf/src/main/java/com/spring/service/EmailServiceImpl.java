package com.spring.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javamailSender;

	@Override
	@Transactional
	public void sendEmail(String toEmail,String pdfPath) {

		String from = "sangram.rapidsoft01@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sangram.rapidsoft01@gmail.com", "Litan@11");
			}
		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		javamailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				message.setFrom(from);
				message.setTo(toEmail);
				message.setSubject("Invoice");
				message.setText("Have a good day, Dear Customer", true);
				message.addAttachment("Invoice.pdf", new File(pdfPath));

			}
		});

	}

}