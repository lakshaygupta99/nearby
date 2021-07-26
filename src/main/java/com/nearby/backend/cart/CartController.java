package com.nearby.backend.cart;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nearby.backend.coupons.Coupon;
import com.nearby.backend.coupons.ResourceNotFoundException;

@RestController
@RequestMapping(path = "api/cart")
public class CartController {

	
	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping(value = "/test")
	public String testF() {
		return "Success";
	}
	
	@PostMapping("/create-cart")
	public Cart createCoupon(@Validated @RequestBody Cart cart) {
		return cartService.save(cart);
	}
	
	@GetMapping("/get-cart/{id}")
	public Cart getCart(@PathVariable(value = "id") Long id) {
		Cart crt =  cartService.getCartOfUser(id);
		
		
		if(crt != null) {
			return crt;
		}else {
			ArrayList<Long> l = new ArrayList<Long>();
			Cart newCart = new Cart(id, l);
			
			return cartService.save(newCart);
		}
		
	}
	
	@PutMapping("/update-cart/{cart_id}")
	public ResponseEntity<Cart> updateCart(@PathVariable(value = "cartId") Long cartId,
			@Validated @RequestBody Cart cart) throws ResourceNotFoundException {
		Cart c = cartService.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + cartId));

		c.setCoupon_ids(cart.getCoupon_ids());
		
		
		final Cart updatedCart = cartService.save(c);
		return ResponseEntity.ok(updatedCart);
	}

}
