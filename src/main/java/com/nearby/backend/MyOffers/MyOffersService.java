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
		return offerRepository.getOffersOfUserByEmail(email);
	}
	
	public MyOffers findOffersByUserId(long id) {
		return offerRepository.getOffersOfUserById(id);
	}
	
	public Coupon findByTransactionDate(String email, long date) {
		MyOffers offer = getOffersOfUser(email);
		int index = offer.getTransactionDate().indexOf(date);
		return couponRepository.getById(offer.getCouponIds().get(index));
	}
	
	public List<Coupon> allOffersPurchased(long id) {
		MyOffers offers = findOffersByUserId(id);
//		CouponService service = new CouponService();
		ArrayList<Coupon> couponList = couponRepository.getCoupons(offers.getCouponIds());
		ArrayList<Coupon> list = new ArrayList<>();
		for(int i=0;i<couponList.size();i++) {
			list.add(couponRepository.findById(offers.getCouponIds().get(i)).get());
		}
		return list;
	}
	
	public Map<String, String> paymentSuccess(Cart cart, boolean paid, MyOffers offers, String address) { 
		String phone = Long.toString(offers.getPhone());
		Map<String,String> map = new HashMap<>();
		map.put("phone", phone);
		map.put("address", address);
		map.put("email", offers.getEmail());
		map.put("couponIDs", cart.getCoupon_ids().toString());
		if(paid) {
			for(int i=0;i<cart.getCoupon_ids().size();i++) {
				offers.getCouponIds().add(cart.getCoupon_ids().get(i));
				couponRepository.reduceCount(offers.getCouponIds().get(i), (long) 1);
				offerRepository.save(offers);
			}
		}
		cartRepository.delete(cart);
		return map;
	}
	

}
