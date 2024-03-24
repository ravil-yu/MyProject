package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UserServiceTest {
    private UserService userService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userService.addUser(new User("Alice", 30));
        userService.addUser(new User("Bob", 25));
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void addUserShouldAddUserToList() {
        User charlie = new User("Charlie", 35);
        userService.addUser(charlie);
        assertEquals(charlie, userService.findUserByName("Charlie"), "User Charlie should be added to the list");
    }

    @Test
    void listUsersShouldPrintOutUsers() {
        userService.listUsers();
        String expectedOutput = "User{name='Alice', age=30}\nUser{name='Bob', age=25}\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim(), "The output should match the expected user list");
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
    void isValidAgeShouldReturnFalseForInvalidAge() {
        assertFalse(userService.isValidAge(-1), "Negative age should be invalid");
        assertFalse(userService.isValidAge(101), "Age greater than 100 should be invalid");
    }

    @Test
    void removeUserShouldSuccessfullyRemoveUserByName() {
        boolean result = userService.removeUser("Alice");
        assertTrue(result, "Should successfully remove user Alice");
        assertNull(userService.findUserByName("Alice"), "Alice should no longer exist after removal");
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
