package com.nearby.backend.users;

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

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

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
//		System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void getAllUsersTest() throws Exception {

		List<User> allUsers = new ArrayList<User>();

		User user1 = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user1.setId(1L);

		User user2 = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user2.setId(2L);

		allUsers.add(user1);
		allUsers.add(user2);

		Mockito.when(userService.getAllUsers()).thenReturn(allUsers);

		RequestBuilder request = MockMvcRequestBuilders.get("/api/users/all-users");
		MvcResult result = mvc.perform(request).andReturn();

		assertEquals(200, result.getResponse().getStatus());

		JSONArray jsonArray = new JSONArray(result.getResponse().getContentAsString());

//		System.out.println(result.getResponse().getContentAsString());

		assertEquals(2, jsonArray.length());
	}

	@Test
	void loginAdminTest() throws Exception {
		Admin admin = new Admin("admin", "admin");

		Mockito.when(userService.loginAdmin((Admin) any(Admin.class))).thenReturn(admin);

		RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login-admin")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(admin));

		MvcResult result = mvc.perform(request).andReturn();

//		System.out.println(result.getResponse().getContentAsString());

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void loginUserTest() throws Exception {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);

		Mockito.when(userService.loginUser((Map<String, String>) any(Map.class))).thenReturn(Optional.of(user));

		RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login-user")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user));

		MvcResult result = mvc.perform(request).andReturn();

//		System.out.println(result.getResponse().getContentAsString());

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void registerUserTest() throws Exception {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);

		Mockito.when(userService.registerUser((User) any(User.class))).thenReturn(user);

		RequestBuilder request = MockMvcRequestBuilders.post("/api/users/register-user")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user));

		MvcResult result = mvc.perform(request).andReturn();

//		System.out.println("REGISTER : "+ result.getResponse().getContentAsString());

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void updateContactTest() throws Exception {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);
		
		Map<String, String> reqMap = new HashMap();
		reqMap.put("phone", "8802235383");
		reqMap.put("address", "C-7/15, Krishna Nagar, Delhi -51");

		Mockito.when(userService.updateContact((Map) any(Map.class),(Long) any(Long.class))).thenReturn(user);
		
		
		RequestBuilder request = MockMvcRequestBuilders.put("/api/users/update-contact/1")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user));

		MvcResult result = mvc.perform(request).andReturn();

//		System.out.println("UPDAT : "+ result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());
	}

}
