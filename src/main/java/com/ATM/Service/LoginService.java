package com.ATM.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateAdmin(String user, String password) {
		return user.equalsIgnoreCase("Admin") && password.equals("Admin");
	}
}