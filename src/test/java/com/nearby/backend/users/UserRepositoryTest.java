package com.nearby.backend.users;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void findAllTest() {
		
		List<User> response = userRepository.findAll();
//		System.out.println(response);
		assertEquals(8,response.size());
	}
	
	@Test
	public void findByEmailTest() {
		User response = userRepository.findByEmail("karan1@gmail.com");
//		System.out.println("RES IS "+ response);
		assertEquals(2,response.getId());
		assertEquals("karan",response.getName());
		assertEquals("karan1",response.getUsername());
		assertEquals("karan1@gmail.com",response.getEmail());
		assertEquals("9896406779",response.getPhone());
	}
	
	@Test
	public void findByUsernameTest() {
		User response = userRepository.findByUsername("karan1");
//		System.out.println("RES IS "+ response);
		
		assertEquals(2,response.getId());
		assertEquals("karan1",response.getUsername());
		assertEquals("karan",response.getName());
		assertEquals("karan1@gmail.com",response.getEmail());
		assertEquals("9896406779",response.getPhone());
	}
	
	
	@Test
	public void findByUsernameAndPasswordTest() {
		User response = userRepository.findByUsernameAndPassword("karan1","karan123").get();
//		System.out.println("RES IS "+ response);
		assertEquals(2,response.getId());
		assertEquals("karan1",response.getUsername());
		assertEquals("karan",response.getName());
		assertEquals("karan1@gmail.com",response.getEmail());
		assertEquals("9896406779",response.getPhone());
	}
	
}
