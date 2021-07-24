package com.nearby.backend.coupons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
