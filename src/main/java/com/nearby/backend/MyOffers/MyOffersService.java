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
	private CartRepository cartRepository;
	
	@Autowired
	private MyOfferRepository offerRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	public MyOffers save(MyOffers offer) {
		return offerRepository.save(offer);
	}
	
	public MyOffers getOffersOfUser(String email) {
		return offerRepository.getOffersOfUser(email);
	}
	public Coupon findByTransactionDate(String email, Long date) {
		MyOffers offer = offerRepository.getOffersOfUser(email);
		int index = offer.getTransactionDate().indexOf(date);
		return couponRepository.getById(offer.getCouponIds().get(index));
	}
	
	public List<Coupon> allOffersPurchased(String email) {
		MyOffers offers = getOffersOfUser(email);
//		CouponService service = new CouponService();
		ArrayList<Coupon> couponList = couponRepository.getCoupons(offers.getCouponIds());
		ArrayList<Coupon> list = new ArrayList<>();
		for(int i=0;i<couponList.size();i++) {
			list.add(couponRepository.findById(offers.getCouponIds().get(i)).get());
		}
		return list;
	}
	
	public Map<String, String> paymentSuccess(Cart cart, boolean paid, MyOffers offers, String name, String phone, String address) { 
		Map<String,String> map = new HashMap<>();
		map.put("phone", phone);
		map.put("address", address);
		map.put("name", name);
		map.put("couponIDs", cart.getCoupon_ids().toString());
		if(paid) {
			for(int i=0;i<cart.getCoupon_ids().size();i++) {
				offers.getCouponIds().add(cart.getCoupon_ids().get(i));
				couponRepository.reduceCount(offers.getCouponIds().get(i), (long) 1);
			}
		}
		cartRepository.delete(cart);
		return map;
	}

}
