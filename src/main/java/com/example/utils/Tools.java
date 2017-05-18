package com.example.utils;

import javax.servlet.http.HttpSession;

public class Tools {
	
	public static final String LOGIN_USER = "loginUser";
	
	public static Object getLoginUser(HttpSession session){
		return session.getAttribute(LOGIN_USER);
	}
	
}
