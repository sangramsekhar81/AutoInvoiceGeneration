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
@Table(name = "account_holder_details")
public class AccountHolderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "account_holder_name")
	private String accountHolderName;

	@Column(name = "account_no")
	private String accountNo;

	// CustomerDetails(id) Foreign key
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetails;
	
	@OneToMany(mappedBy="accountHolderDetails")
	@JsonIgnore
	private List<Bank> allBank;
	
	@JsonIgnore
	@OneToMany(mappedBy = "accountHolderDetails",cascade = CascadeType.ALL)
	private List<Orders> orders;
	

	public AccountHolderDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public List<Bank> getAllBank() {
		return allBank;
	}

	public void setAllBank(List<Bank> allBank) {
		this.allBank = allBank;
	}

	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "AccountHolderDetails [id=" + id + ", accountHolderName=" + accountHolderName + ", accountNo="
				+ accountNo + ", customerDetails=" + customerDetails + ", allBank=" + allBank + "]";
	}
	
}