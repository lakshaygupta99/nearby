package com.nearby.backend.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Transactional
@Entity
@Table(name = "users")
public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + "]";
	}

	private Long id;
	private String name;
	private String username;
	

	private String email;
	private String password;
	private String phone;
	private String address;

	public User(String name, String username, String email, String password, String phone, String address) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name = "username", nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty(message = "Email is required")
    @Email
	@Column(name = "email", nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", nullable = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
