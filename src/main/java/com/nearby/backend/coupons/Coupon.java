package com.nearby.backend.coupons;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;

@Transactional
@Entity
@Table(name = "coupons")
public class Coupon {

	private Long id;
	private String name;
	private String description;
	private String image;
	private Integer count;
	private String shopName;
	private String city;
	private String area;
	private String code;
	private Long price;
	private ArrayList<Long> likedBy;

	public Coupon(String name, String description, String image, Integer count, String shopName, String city,
			String area, String code, Long price) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.count = count;
		this.shopName = shopName;
		this.city = city;
		this.area = area;
		this.code = code;
		this.price= price;	}

	public Coupon() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "count", nullable = false)
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "shop_name", nullable = false)
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", nullable = false)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "price", nullable = false)
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Column(name = "likedBy")
	public ArrayList<Long> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(ArrayList<Long> likedBy) {
		this.likedBy = likedBy;
	}

	
}
