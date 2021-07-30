package com.nearby.backend.MyOffers;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.backend.cart.Cart;
import com.nearby.backend.coupons.Coupon;

@RestController
@RequestMapping(path = "api/myOffers")
public class MyOffersController {
	
	private final MyOffersService offerService; 
	
	@Autowired
	public MyOffersController(MyOffersService service) {
		this.offerService = service;
	}
	
	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping(value = "/findByTransaction/{email}/{date}")
	public Coupon findByDate(@PathVariable(value = "email") String email, @PathVariable(value = "date") Long date) {
		return offerService.findByTransactionDate(email, date);
	}
	
	@GetMapping(value = "/myOffers-purchased/{email}")
	public List<Coupon> getAllOffers(@PathVariable(value = "email") String email){
		return offerService.allOffersPurchased(email);
	}
	
//	@PutMapping(value = "/payment-success")
//	public Map<String, String> payment(@Validated @RequestBody Cart cart, boolean paid, MyOffers offers, String name, String phone, String address){
//		return offerService.paymentSuccess(cart,paid,offers,name,phone,address);
//	}

}