package com.nearby.backend.users;

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

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	public void getAllUsersTest() {

		List<User> allUsers = new ArrayList<User>();

		User user1 = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user1.setId(1L);

		User user2 = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user2.setId(2L);

		allUsers.add(user1);
		allUsers.add(user2);

		Mockito.when(userRepository.findAll()).thenReturn(allUsers);

		List<User> response = userService.getAllUsers();
//		System.out.println(response);
		assertEquals(response, allUsers);
	}

	@Test
	void loginAdminTest() throws Exception {
		Admin admin = new Admin("admin", "admin");

		Admin response = userService.loginAdmin(admin);
//		System.out.println(admin);

		assertEquals(admin.getPassword(), response.getPassword());
		assertEquals(admin.getUsername(), response.getUsername());
	}

	@Test
	void registerUserTest() throws Exception {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);

		Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
		Mockito.when(userRepository.save(user)).thenReturn(user);

		User response = userService.registerUser(user);
//		System.out.println(response);

		assertEquals(1, response.getId());
		assertEquals("aman", response.getName());
		assertEquals("aman", response.getUsername());
		assertEquals("aman.ahuja680@gmail.com", response.getEmail());
		assertEquals("8802235383", response.getPhone());
	}

	@Test
	void loginUserTest() {
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);

		Map<String, String> reqMap = new HashMap();
		reqMap.put("username", "aman");
		reqMap.put("password", "amanahuja123");

		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()))
				.thenReturn(Optional.of(user));

		User response = userService.loginUser(reqMap).get();
//		System.out.println(response);
		assertEquals(1, response.getId());
		assertEquals("aman", response.getName());
		assertEquals("aman", response.getUsername());
		assertEquals("aman.ahuja680@gmail.com", response.getEmail());
		assertEquals("8802235383", response.getPhone());

	}

	@Test
	void updateContactTest() throws Exception {
		
		User user = new User("aman", "aman", "aman.ahuja680@gmail.com", "amanahuja123", "8802235383",
				"C-7/15, Krishna Nagar, Delhi -51");
		user.setId(1L);
		
		
		Map<String, String> reqMap = new HashMap();
		reqMap.put("phone", "8802235383");
		reqMap.put("address", "C-7/15, Krishna Nagar, Delhi -51");
		
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		Mockito.when(userRepository.save(user)).thenReturn(user);

		
		User response = userService.updateContact(reqMap, 1L);
		
//		System.out.println("UPDATE"+response);
		assertEquals(1, response.getId());
		assertEquals("aman", response.getName());
		assertEquals("aman", response.getUsername());
		assertEquals("aman.ahuja680@gmail.com", response.getEmail());
		assertEquals("8802235383", response.getPhone());

	}

}
