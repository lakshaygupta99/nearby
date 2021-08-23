package com.nearby.backend.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	UserController controller;

	@MockBean
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	void hello() {
		assertEquals("Hello", controller.hello());
	}

	@Test
	void hello2() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/api/users/hello");
		MvcResult result = mvc.perform(request).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void getAllUsers() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/api/users/all-users");
		MvcResult result = mvc.perform(request).andReturn();
//		System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void loginAdmin() throws Exception {
		Admin admin = new Admin("admin", "admin");

		RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login-admin")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(admin));

		MvcResult result = mvc.perform(request).andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void loginUser() throws Exception {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);
		

		RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login-user")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user));

		MvcResult result = mvc.perform(request).andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}

}
