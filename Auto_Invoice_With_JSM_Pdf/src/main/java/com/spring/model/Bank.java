package com.spring.model;

import java.util.List;

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
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "bank_name")
	private String bankName;

	// AccountHolderDetails(id) Foreign key
	@ManyToOne
	@JsonIgnore
	private AccountHolderDetails accountHolderDetails;

	@OneToMany(mappedBy = "bank")
	@JsonIgnore
	private List<Ifsc> allIfsc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bank")
	private List<Orders> orders;

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Bank() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public AccountHolderDetails getAccountHolderDetails() {
		return accountHolderDetails;
	}

	public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
		this.accountHolderDetails = accountHolderDetails;
	}

	public List<Ifsc> getAllIfsc() {
		return allIfsc;
	}

	public void setAllIfsc(List<Ifsc> allIfsc) {
		this.allIfsc = allIfsc;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", accountHolderDetails=" + accountHolderDetails
				+ ", allIfsc=" + allIfsc + "]";
	}

}
