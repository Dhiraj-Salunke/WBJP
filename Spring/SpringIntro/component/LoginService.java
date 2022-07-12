package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("loginService")
public class LoginService {

	public boolean isValidUser(String username, String password) {
		if(username.equals("Dhiraj") && password.equals("luffy"))
			return true;
		return false;
	}
}
