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
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return ResponseEntity.ok(userService.getAllUsers());
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}

	}

	@PostMapping("/register-user")
	public ResponseEntity<User> registerUser(@Validated @RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.registerUser(user));
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}

	}

	@PostMapping("/login-user")
	public ResponseEntity<Optional<User>> loginUser(@RequestBody Map<String, String> reqMap) {
		try {
			
			Optional<User> user = userService.loginUser(reqMap);
			return ResponseEntity.ok().body(user);
		}
		catch(Exception e) {
			return ResponseEntity.status(400).body(null);
		}
		
	}

	@PostMapping("/login-admin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		try {
			return ResponseEntity.ok(userService.loginAdmin(admin));
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}
}
