package com.nearby.backend.coupons;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();

	}

	public Coupon save(Coupon coupon) {
		return couponRepository.save(coupon);
	}

	public Optional<Coupon> findById(Long id) {
		Optional<Coupon> coupon = couponRepository.findById(id);
		return coupon;
	}

	public List<Coupon> getCouponsBasedOnCity(String city) {
		List<Coupon> list = couponRepository.findByCityIgnoreCase(city);
		return list;
	}

	public List<Coupon> getCouponsBasedOnArea(String city, String area) {
		List<Coupon> list = couponRepository.findByCityAndAreaIgnoreCase(city, area);
		return list;
	}

	public void delete(Coupon coupon) {
		// TODO Auto-generated method stub
		couponRepository.delete(coupon);
		
	}

}
