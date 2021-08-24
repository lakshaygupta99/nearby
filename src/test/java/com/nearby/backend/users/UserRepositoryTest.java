package com.nearby.backend.users;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void findAllTest() {
		
		List<User> response = userRepository.findAll();
		System.out.println(response);
		assertEquals(8,response.size());

	}

}
