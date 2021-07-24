package com.nearby.backend.coupons;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/coupons")
public class CouponController {

	private final CouponService couponService; 
	
	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}
	
	
	@GetMapping(value = "/all-coupons")
	public List<Coupon> getAllCoupons(){
		return couponService.getAllCoupons();
	}
	
	 @PostMapping("/create-coupon")
	    public Coupon createCoupon(@Validated @RequestBody Coupon coupon) {
	        return couponService.save(coupon);
	    }


}
