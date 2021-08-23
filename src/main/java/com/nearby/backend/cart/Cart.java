package com.nearby.backend.cart;


import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nearby.backend.users.User;

@Transactional
@Entity
@Table(name = "cart")
public class Cart {

	private Long id;
	
	private Long createdBy;

	private ArrayList<Long> coupon_ids;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long createdBy, ArrayList<Long> coupon_ids) {
		super();
		this.createdBy = createdBy;
		this.coupon_ids = coupon_ids;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false, unique=true)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "coupon_ids")
	public ArrayList<Long> getCoupon_ids() {
		return coupon_ids;
	}

	public void setCoupon_ids(ArrayList<Long> coupon_ids) {
		this.coupon_ids = coupon_ids;
	}

}
