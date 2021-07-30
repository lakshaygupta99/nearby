package com.nearby.backend.MyOffers;
import com.nearby.backend.cart.Cart;
import com.nearby.backend.cart.CartRepository;
import com.nearby.backend.coupons.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOffersService {

	@Autowired
	private MyOfferRepository offerRepository;

	@Autowired
	private CartRepository cartRepository;
	
	public List<MyOffers> getAllMyOffers() {
		return offerRepository.findAll();

	}
	
	public MyOffers paymentSuccess(String email, Long id, ArrayList<Long>coupons, String phone, String address, Long CartId) { 
		
		MyOffers of = new MyOffers(id, email, coupons, address, phone);
		//System.out.println(of.getCouponIds());
		cartRepository.deleteById(CartId);
		return offerRepository.save(of);
	}

	public List<MyOffers> allOffersPurchased(long userId) {
		// TODO Auto-generated method stub
		return  offerRepository.findByUserId(userId);
	}


	

}
