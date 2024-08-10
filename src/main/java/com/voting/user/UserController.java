package com.voting.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//
//	@PostMapping("/signup")
//	public ResponseEntity<User> signUp(@RequestBody User user) {
//		User newUser = userService.createUser(user);
//		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
//	}
//
////    @PostMapping("/login")
////    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
////        User user = userService.loginUser(email, password);
////        if (user != null && user.getPassword().equals(password)) {
////        	System.out.println(user.getPassword());
////            return ResponseEntity.ok(user);
////        } else {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
////        }
////    }
//
//	@PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
//        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//    }
//}


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        // Check if the email already exists
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
