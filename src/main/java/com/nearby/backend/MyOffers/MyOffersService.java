package com.nearby.backend.MyOffers;
import com.nearby.backend.cart.Cart;
import com.nearby.backend.cart.CartRepository;
import com.nearby.backend.coupons.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyOffersService {

	@Autowired
	private MyOfferRepository offerRepository;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	public List<MyOffers> getAllMyOffers() {
		return offerRepository.findAll();

	}
	
	public MyOffers paymentSuccess(String email, Long id, ArrayList<Long>coupons, String phone, String address, Long CartId) { 
		
		MyOffers of = new MyOffers(id, email, coupons, address, phone);
		//System.out.println(of.getCouponIds());
		
		// parallel checkout -> if only one coupon is left
		
		cartRepository.deleteById(CartId);
		Long qty = (long) 1;
		for(int i = 0;i< coupons.size(); i++) {
			couponRepository.reduceCount(coupons.get(i),qty);
		}
		
		return offerRepository.save(of);
	}

	public List<MyOffers> allOffersPurchased(long userId) {
		// TODO Auto-generated method stub
		return  offerRepository.findByUserId(userId);
	}


	

}
