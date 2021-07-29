package com.nearby.backend.MyOffers;

import java.util.List;

public class MyOffers {
	private String email;
	private List<Long> couponIds;
	private List<Long> transactionDate;
	
	public MyOffers(String email, List<Long> couponIds, List<Long> transactionDate) {
		this.email = email;
		this.couponIds = couponIds;
		this.transactionDate = transactionDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(List<Long> couponIds) {
		this.couponIds = couponIds;
	}

	public List<Long> getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(List<Long> transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	
}
