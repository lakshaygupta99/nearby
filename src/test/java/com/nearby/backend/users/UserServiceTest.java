package com.nearby.backend.users;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	public void getAllUsers() {

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

}
