package com.nearby.backend.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	 @PostMapping("/register-user")
	    public User registerUser(@Validated @RequestBody User user) {
	         return userService.registerUser(user);
	         
	 }
	 
	
	 @PostMapping("/login-user/{username}")
	 public User loginUser(@PathVariable(value = "username") String username) {
		 return userService.loginUser(username);
	    }
}
