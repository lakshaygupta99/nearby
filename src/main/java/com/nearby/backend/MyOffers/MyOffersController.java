package com.nearby.backend.MyOffers;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping(value = "/myOffers-purchased")
	public List<Coupon> getAllOffers(MyOffers offers){
		return offerService.allOffersPurchased(offers);
	}
	
	@GetMapping(value = "/payment-success")
	public Map<String, String> payment(Cart cart, boolean paid, MyOffers offers, String name, String phone, String address){
		return offerService.paymentSuccess(cart,paid,offers,name,phone,address);
	}

}