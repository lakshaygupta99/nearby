package com.nearby.backend.users;

public class Error {

	private String error;
	private int statusCode;
	public Error(String error, int i) {
		super();
		this.error = error;
		this.statusCode = i;
	}
}
