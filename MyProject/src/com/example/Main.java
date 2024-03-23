package com.example;

public class Main {

	public static void main(String[] args) {
		  UserService userService = new UserService();
	        
	        userService.addUser(new User("Alice", 30));
	        userService.addUser(new User("Bob", 25));
	        
	        System.out.println("Current users:");
	        userService.listUsers();
	}

}
