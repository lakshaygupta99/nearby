package com.nearby.backend.MyOffers;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.nearby.backend.coupons.Coupon;

@Entity
@Table(name = "myOffers")
public class MyOffers{
	private long id;
	private long userId;
	private String phone;
	private String email;
	private String address;
	private ArrayList<Long> coupons;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_date")
	private Date transactionDate;

	public MyOffers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyOffers(Long userId, String email, ArrayList<Long> coupons, String address, String phone) {
		this.email = email;
		this.coupons = coupons;
		this.address = address;
		this.userId = userId;
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "coupons")
	public ArrayList<Long> getCouponIds() {
		return coupons;
	}

	public void setCouponIds(ArrayList<Long> couponIds) {
		this.coupons = coupons;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name = "Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "userId")
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
