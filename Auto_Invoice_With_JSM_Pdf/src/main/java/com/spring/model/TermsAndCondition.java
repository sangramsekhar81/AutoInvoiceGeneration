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
@Table(name = "terms_and_condition")
public class TermsAndCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "terms_body_text")
	private String termsBodyText;

	// ProductDetails(id)-Foreign key
	@JsonIgnore
	@ManyToOne
	private ProductDetails productDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "termsAndCondition")
	private List<Orders> orders;

	public TermsAndCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTermsBodyText() {
		return termsBodyText;
	}

	public void setTermsBodyText(String termsBodyText) {
		this.termsBodyText = termsBodyText;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "TermsAndCondition [id=" + id + ", termsBodyText=" + termsBodyText + ", productDetails=" + productDetails
				+ ", orders=" + orders + "]";
	}

}
