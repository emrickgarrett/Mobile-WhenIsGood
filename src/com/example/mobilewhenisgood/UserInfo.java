package com.example.mobilewhenisgood;

import java.io.Serializable;

/**
 * 
 * @author Garrett
 * Dummy class to simulate the user already being logged in.
 */
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName = "GarrettEmrick";
	private String password = "abc123";
	
	public String getUserName(){return userName;}
	public String getPassword(){return password;}
	
}
