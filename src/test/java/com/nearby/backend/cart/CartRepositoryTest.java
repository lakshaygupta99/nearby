package com.nearby.backend.cart;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
public class CartRepositoryTest {

	@Autowired
	CartRepository cartRepository;

	@Test
	public void getCartOfUserTest() {
		Cart cart = cartRepository.getCartOfUser(1L);
		//System.out.println(cart);
		assertEquals(31, cart.getId());
		
	}

}
