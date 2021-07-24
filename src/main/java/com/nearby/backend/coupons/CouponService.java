package com.nearby.backend.coupons;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CouponService {

	public List<Coupon> getAllCoupons() {
		return List.of(new Coupon(1L, "Flat 50%", "Can be availed only on online transaction!", "url", 1000, "Dineout",
				"Bathinda", "Greencity"

		));
	}

}
