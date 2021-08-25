package com.nearby.backend.cart;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nearby.backend.users.UserRepository;
import com.nearby.backend.users.UserService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	
	@InjectMocks
	CartService cartService;

	@MockBean
	CartRepository cartRepository;
	
	
	@Test
	public void getCartOfUserTest() {
		Cart cart = cartService.getCartOfUser(1L);
		assertEquals(31, cart.getId());
	}
	
//	@Test
//	public void findByIdTest() {
//		Optional<Cart> cart = cartService.findById(31L);
//		System.out.println("hello " + cart);
//	}
	

}
