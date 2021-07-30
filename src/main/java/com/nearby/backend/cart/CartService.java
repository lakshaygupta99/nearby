package com.nearby.backend.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearby.backend.coupons.Coupon;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart getCartOfUser(Long id) {
		return cartRepository.getCartOfUser(id);
	}

	public List<Cart> getAllCarts() {
		return cartRepository.findAll();

	}
	public Optional<Cart> findById(Long cartId) {
		// TODO Auto-generated method stub
		Optional<Cart> cart = cartRepository.findById(cartId);
		return cart;

	}

}
