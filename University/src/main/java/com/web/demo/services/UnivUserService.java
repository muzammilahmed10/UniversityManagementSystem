package com.web.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entites.UnivUser;
import com.web.demo.repositories.UnivUserRepository;

@Service
public class UnivUserService {

	@Autowired
	UnivUserRepository univrepo;
	
	public String authenticateUser(String email,String password) {
		UnivUser user = univrepo.findByEmail(email);
		
		if(user == null) {
			return "Invalid EmailId or password";
		}
		else {
			if (user.getPassword().equals(password)) {
				return user.getRole();
			}
			else {
				return "Invalid Email or password";
			}
		}
	}
}
