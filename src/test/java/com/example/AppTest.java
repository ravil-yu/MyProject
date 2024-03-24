package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userService.addUser(new User("Alice", 30));
        userService.addUser(new User("Bob", 25));
    }

    @Test
    void isValidAgeShouldReturnTrueForValidAge() {
        assertTrue(userService.isValidAge(25), "Age within range should be valid");
    }

    @Test
    void findUserByNameShouldReturnUserIfExists() {
        User user = userService.findUserByName("Alice");
        assertNotNull(user, "Should find user Alice");
        assertEquals("Alice", user.getName(), "The name of the user should be Alice");
    }

    @Test
    void removeUserShouldSuccessfullyRemoveUserByName() {
        boolean result = userService.removeUser("Alice");
        assertTrue(result, "Should successfully remove user Alice");
        assertNull(userService.findUserByName("Alice"), "Alice should no longer exist after removal");
    }
    
}

