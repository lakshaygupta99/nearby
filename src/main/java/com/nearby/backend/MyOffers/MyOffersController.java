package com.nearby.backend.MyOffers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.backend.cart.Cart;
import com.nearby.backend.cart.CartService;
import com.nearby.backend.coupons.Coupon;
import com.nearby.backend.coupons.CouponService;

@RestController
@RequestMapping(path = "api/myOffers")
public class MyOffersController {

	private final MyOffersService offerService;
	private final CartService cartService;
	private final CouponService couponService;
	@Autowired
	public MyOffersController(MyOffersService service, CartService cartService, CouponService couponService) {
		this.offerService = service;
		this.cartService = cartService;
		this.couponService = couponService;
	}

	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}

	@GetMapping(value = "/all-offers")
	public List<MyOffers> getAllMyOffers() {
		return offerService.getAllMyOffers();
	}
//	@GetMapping(value = "/findByTransaction/{userId}/{date}")
//	public MyOffers findByDate(@PathVariable(value = "userId") Long userId, @PathVariable(value = "date") String date) {
//		try {
//			return offerService.findByTransactionDate(userId, date);
//		} catch (Exception e) {
//			return null;
//		}
//	}

	@GetMapping(value = "/myOffers-purchased/{userId}")
	public List<MyOffers> getAllOffers(@PathVariable(value = "userId") long userId) {
		try {
			return offerService.allOffersPurchased(userId);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@PostMapping(value = "/payment-success/{phone}/{address}")
	public MyOffers payment(@Validated @RequestBody Map<String, Object> request,
			@PathVariable(value = "phone") String phone, @PathVariable(value = "address") String address) {
try {
	Long cartId = ((Number) request.get("cartId")).longValue();
	String email = (String) request.get("email");
	Long userId = ((Number) request.get("userId")).longValue();
	Cart c = new Cart();
	c = cartService.getCartOfUser(userId);
	return offerService.paymentSuccess(email, userId, c.getCoupon_ids(), phone, address, cartId);
}catch(Exception e) {

	System.out.println(e);
	return null;
}

	}

}