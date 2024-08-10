package com.voting.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin loginUser(String email, String password) {
		return adminRepository.findByEmail(email);
	}
}
