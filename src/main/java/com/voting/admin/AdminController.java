package com.voting.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voting.user.LoginRequest;
import com.voting.user.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/adminlogin")
    public ResponseEntity<Admin> login(@RequestBody LoginRequest loginRequest) {
        Admin user = adminService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

}
