package com.nearby.backend.users;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/all-users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	 @PostMapping("/register-user")
	    public User registerUser(@Validated @RequestBody User user) {
	         return userService.registerUser(user);
	         
	 }
	 
	 @PostMapping("/login-user")
	 public User loginUser(@RequestBody Map<String,String> reqMap) {
		 return userService.loginUser(reqMap);
	 }
	 
	 @PostMapping("/login-admin")
	 public Admin loginAdmin(@RequestBody Admin admin) {
		 return userService.loginAdmin(admin);
	 }
}
