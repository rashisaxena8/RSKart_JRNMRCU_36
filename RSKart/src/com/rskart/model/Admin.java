package com.rskart.model;

public class Admin {

	private static String userName;
	private static String password;

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		Admin.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Admin.password = password;
	}
	static {
		userName="rashi";
		password="7777777";
	}



}