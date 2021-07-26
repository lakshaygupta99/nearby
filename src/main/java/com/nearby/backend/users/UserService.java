package com.nearby.backend.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
    private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

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
	public User loginUser(Map<String,String> reqMap) {
		String username = reqMap.get("username");
		String password = reqMap.get("password");
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	public Admin loginAdmin(Admin admin) {
		String username = admin.getUsername();
		String password = admin.getPassword();
		
		if(username.equals("admin") && password.equals("admin"))
			return admin;
		else
			return null;
	}
}
