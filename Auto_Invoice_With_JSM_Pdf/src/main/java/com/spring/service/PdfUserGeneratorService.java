package com.spring.service;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.model.Transaction;

@Service
public class PdfUserGeneratorService {

	@Autowired
	private TransactionService transactionService;

    List<Transaction> list;


		
      public PdfUserGeneratorService(List<Transaction> list) {
		this.list = list;
	}


	private void writeTableHeader(PdfPTable table) {
	   
	   PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(4);

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.white);
		cell.setPhrase(new Phrase("INVOICE NO.", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("CUSTOMER NAME", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("CUSTOMER GST NO", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PRODUCT NAME", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("INVOICE DATE", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("TOTAL AMOUNT", font));
		table.addCell(cell);
		
	  
   }
   

	public void writeTableData(PdfPTable table) {
		for (Transaction t: list) {
			table.addCell(String.valueOf(t.getInvoiceNo()));
			table.addCell(t.getCustomerDetails().getCustomerName());
			table.addCell(t.getCustomerDetails().getCustomerGstNumber());
			table.addCell(t.getProductDetails().getProductName());
			table.addCell(String.valueOf(t.getInvoiceDate()));
			table.addCell(String.valueOf(t.getTotalAmount()));
		}

	}
	
	public ResponseEntity<?> export(String pdf_Path) throws IOException, DocumentException {
		Document document = new Document(PageSize.A3);
		
		PdfWriter.getInstance(document, new FileOutputStream(pdf_Path));

		document.open();
		

		
		Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);

		Paragraph p = new Paragraph("List Of Transaction", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
	

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 2.8f,2.5f,2.3f,2.3f,2.0f});
		table.setSpacingBefore(10);
		
	 	writeTableHeader(table);
		writeTableData(table);
	

		document.add(table);
		document.close();
		
		return new ResponseEntity<>(HttpStatus.OK);

	}


}
