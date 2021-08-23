package com.nearby.backend.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.nearby.backend.coupons.CouponService;
import com.nearby.backend.coupons.ResourceNotFoundException;

@RestController
@RequestMapping(path = "api/cart")
public class CartController {

	private final CartService cartService;
	private final CouponService couponService;

	@Autowired
	public CartController(CartService cartService, CouponService couponService) {
		this.cartService = cartService;
		this.couponService = couponService;
	}

	@GetMapping(value = "/test")
	public String testF() {
		return "Success";
	}

	@GetMapping(value = "/all-carts")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@PostMapping("/create-cart")
	public ResponseEntity<Object> createCart(@Validated @RequestBody Cart cart) {
		try {

			return ResponseEntity.ok(cartService.save(cart));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@GetMapping("/get-cart/{id}")
	public ResponseEntity<Object> getCart(@PathVariable(value = "id") Long id) {
		Cart crt = cartService.getCartOfUser(id);

		try {
			if (crt != null) {
				return ResponseEntity.ok().body(crt);
			} else {
				ArrayList<Long> l = new ArrayList<Long>();
				Cart newCart = new Cart(id, l);

				return ResponseEntity.ok(cartService.save(newCart));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@PutMapping("/update-cart/{cartId}")
	public ResponseEntity<Object> updateCart(@PathVariable(value = "cartId") Long cartId,
			@Validated @RequestBody Cart cart) throws ResourceNotFoundException {

		try {
			Cart c = cartService.findById(cartId)
					.orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id: " + cartId));

			c.setCoupon_ids(cart.getCoupon_ids());

			final Cart updatedCart = cartService.save(c);
			return ResponseEntity.ok(updatedCart);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

	@GetMapping("/cart-coupons/{cartId}")
	public ResponseEntity<Object> getCoupons(@PathVariable(value = "cartId") Long cartId) {
		try {
			Cart c = cartService.findById(cartId)
					.orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id: " + cartId));

			return ResponseEntity.ok((ArrayList<Coupon>) couponService.getCoupons(c.getCoupon_ids()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
		}

	}

}
