package com.spring.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "hsn_code")
	private String hsncode;
	@Column(name = "repeat_every")
	private String repeatEvery;

	@Column(name = "start_on")
	private String startOn;

	@Column(name = "end_on")
	private String endOn;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "units")
	private int units;
	
	@Column(name = "price_per_units")
	private int pricePerUnits;


	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetails;
	

	@JsonIgnore
	@OneToMany(mappedBy = "productDetails")
	private List<TermsAndCondition> allTermsAndConditions;

	@JsonIgnore
	@OneToMany(mappedBy = "productDetails",cascade = CascadeType.ALL)
	private List<Orders> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "productDetails",cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public List<TermsAndCondition> getAllTermsAndConditions() {
		return allTermsAndConditions;
	}

	public void setAllTermsAndConditions(List<TermsAndCondition> allTermsAndConditions) {
		this.allTermsAndConditions = allTermsAndConditions;
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

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getRepeatEvery() {
		return repeatEvery;
	}

	public void setRepeatEvery(String repeatEvery) {
		this.repeatEvery = repeatEvery;
	}

	public String getStartOn() {
		return startOn;
	}

	public void setStartOn(String startOn) {
		this.startOn = startOn;
	}

	public String getEndOn() {
		return endOn;
	}

	public void setEndOn(String endOn) {
		this.endOn = endOn;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(int pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	

	
	

}
