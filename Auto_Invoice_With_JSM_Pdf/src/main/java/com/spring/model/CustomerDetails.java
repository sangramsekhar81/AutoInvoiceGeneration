package com.spring.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private int id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_gst_number")
	private String customerGstNumber;
	
	@Column(name="customer_address")
	private String customerAddress;
	
	@Column(name="email")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "customerDetails" ,cascade =CascadeType.ALL)
	private List<ProductDetails> allProduct;
	
	@JsonIgnore
	@OneToMany(mappedBy="customerDetails",cascade = CascadeType.ALL)
	private List<AccountHolderDetails> allAccountDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy="customerDetails")
	private List<Orders> orders;

	@JsonIgnore
	@OneToMany(mappedBy="customerDetails")
	private List<Transaction> transactions;

	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGstNumber() {
		return customerGstNumber;
	}

	public void setCustomerGstNumber(String customerGstNumber) {
		this.customerGstNumber = customerGstNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	public List<ProductDetails> getAllProduct() {
		return allProduct;
	}

	public void setAllProduct(List<ProductDetails> allProduct) {
		this.allProduct = allProduct;
	}

	public List<AccountHolderDetails> getAllAccountDetails() {
		return allAccountDetails;
	}

	public void setAllAccountDetails(List<AccountHolderDetails> allAccountDetails) {
		this.allAccountDetails = allAccountDetails;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", customerName=" + customerName + ", customerGstNumber="
				+ customerGstNumber + ", customerAddress=" + customerAddress + ", email=" + email + ", allProduct="
				+ allProduct + ", allAccountDetails=" + allAccountDetails + ", orders=" + orders + ", transactions="
				+ transactions + "]";
	}
	
	
	
	
	
}
