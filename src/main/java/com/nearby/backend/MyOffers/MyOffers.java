package com.nearby.backend.MyOffers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myOffers")
public class MyOffers {
	private Long Id;
	private String email;
	private ArrayList<Long> couponIds;
	private ArrayList<Long> transactionDate;
	
	public MyOffers(String email, ArrayList<Long> couponIds, ArrayList<Long> transactionDate) {
		this.email = email;
		this.couponIds = couponIds;
		this.transactionDate = transactionDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		this.Id = id;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "couponIds")
	public ArrayList<Long> getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(ArrayList<Long> couponIds) {
		this.couponIds = couponIds;
	}

	@Column(name = "transactionDate")
	public ArrayList<Long> getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(ArrayList<Long> transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	
}
