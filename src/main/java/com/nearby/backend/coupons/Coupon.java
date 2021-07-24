package com.nearby.backend.coupons;

class Coupon {

	private Long id;
	private String name;
	private String description;
	private String image;
	private Integer count;
	private String shopName;
	private String city;
	private String area;
	
	public Coupon(Long id, String name, String description, String image, Integer count, String shopName, String city,
			String area) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.count = count;
		this.shopName = shopName;
		this.city = city;
		this.area = area;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
