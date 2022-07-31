package com.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// FOREIGN KEY customer_details(id)
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetails;

	// FOREIGN KEY product_details(id)
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductDetails productDetails;

	// FOREIGN KEY terms_and_conditions(id)
	@ManyToOne(cascade = CascadeType.ALL)
	private TermsAndCondition termsAndCondition;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AccountHolderDetails accountHolderDetails;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Bank bank;

	@ManyToOne(cascade = CascadeType.ALL)
	private Ifsc ifsc;
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	private List<Transaction> transactions;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ifsc getIfsc() {
		return ifsc;
	}

	public void setIfsc(Ifsc ifsc) {
		this.ifsc = ifsc;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public TermsAndCondition getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(TermsAndCondition termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	
	public AccountHolderDetails getAccountHolderDetails() {
		return accountHolderDetails;
	}

	public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
		this.accountHolderDetails = accountHolderDetails;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
