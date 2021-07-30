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
	private long userId;
	private long phone;
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
	public long getId() {
		return userId;
	}
	
	public void setId(Long id) {
		this.userId = id;
	}
	
	@Column(name = "phone")
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
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
