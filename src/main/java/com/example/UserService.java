package com.example;
import java.util.ArrayList;
import java.util.List;
public class UserService {
	private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void listUsers() {
        users.forEach(System.out::println);
    }
    public boolean isValidAge(int age) {
        return age >= 0 && age <= 100;
    }
    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    public boolean removeUser(String name) {
        return users.removeIf(user -> user.getName().equals(name));
    }

}
