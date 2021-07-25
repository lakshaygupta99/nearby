package com.nearby.backend.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
    private UserRepository userRepository;

	public User registerUser(User user) {
		User user1 = userRepository.findByEmail(user.getEmail());
		User user2 = userRepository.findByUsername(user.getUsername());
		if(user1!=null || user2!=null) {
			return null;
		}
		else {
			return userRepository.save(user);
		}
	}
	public User loginUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	
}
