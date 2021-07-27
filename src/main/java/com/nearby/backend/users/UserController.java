package com.nearby.backend.users;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.nearby.backend.coupons.ResourceNotFoundException;

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
	public ResponseEntity<User> loginUser(@RequestBody Map<String, String> reqMap) {
		try {
			User user = userService.loginUser(reqMap);

			return ResponseEntity.ok().body(user);
		} catch (Exception e) {

		}
		return null;

	}

	@PostMapping("/login-admin")
	public Admin loginAdmin(@RequestBody Admin admin) {
		return userService.loginAdmin(admin);
	}
}
