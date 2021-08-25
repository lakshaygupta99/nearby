package com.nearby.backend.cart;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nearby.backend.coupons.Coupon;
import com.nearby.backend.coupons.CouponService;
import com.nearby.backend.users.User;
import com.nearby.backend.users.UserController;
import com.nearby.backend.users.UserRepository;
import com.nearby.backend.users.UserService;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CartController.class)
public class CartControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	CartController controller;

	@MockBean
	CouponService couponService;

	@MockBean
	CartService cartService;

	@MockBean
	CartRepository cartRepository;

	@Test
	public void getCouponsTest() throws Exception {

		List<Coupon> listTest = new ArrayList<Coupon>();
		Coupon testingCoupon = new Coupon("test", "test", "test", 100, "test", "test", "test", "test", 200L);
		testingCoupon.setId(2L);
		listTest.add(testingCoupon);

		ArrayList<Long> TestCoupons = new ArrayList<Long>();
		TestCoupons.add(1L);
		Optional<Cart> c = Optional.ofNullable(new Cart(1L, TestCoupons));
		Mockito.when(cartService.findById((Long) any(Long.class))).thenReturn(c);
		Mockito.when(couponService.getCoupons((ArrayList<Long>) any(ArrayList.class)))
				.thenReturn((ArrayList<Coupon>) listTest);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/cart/cart-coupons/31");
		MvcResult result = mvc.perform(request).andReturn();
//	System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	public void updateCartTest() throws Exception {

		ArrayList<Long> TestCoupons = new ArrayList<Long>();
		TestCoupons.add(1L);
		Optional<Cart> c = Optional.ofNullable(new Cart(1L, TestCoupons));
		Mockito.when(cartService.findById((Long) any(Long.class))).thenReturn(c);

		Cart c1 = new Cart(1L, TestCoupons);
		c1.setId(2L);
		Mockito.when(cartService.save((Cart) any(Cart.class))).thenReturn(c1);

		RequestBuilder request = MockMvcRequestBuilders.put("/api/cart/update-cart/1")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(c1));

		MvcResult result = mvc.perform(request).andReturn();

//		System.out.println("REGISTER : "+ result.getResponse().getContentAsString());

	}

	@Test
	public void getCartTest() throws Exception {

		ArrayList<Long> TestCoupons = new ArrayList<Long>();
		TestCoupons.add(1L);
		Optional<Cart> c = Optional.ofNullable(new Cart(1L, TestCoupons));
		Mockito.when(cartService.findById((Long) any(Long.class))).thenReturn(c);

		Cart c1 = new Cart(1L, TestCoupons);
		c1.setId(2L);
		Mockito.when(cartService.save((Cart) any(Cart.class))).thenReturn(c1);

		RequestBuilder request = MockMvcRequestBuilders.get("/api/cart/get-cart/1");
		MvcResult result = mvc.perform(request).andReturn();
//	System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

}
