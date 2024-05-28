package com.abs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testUserConstructorAndGetters() {
        // Given
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String password = "password";
        Role role = Role.MANAGER;

        // When
        User user = new User(id, firstName, lastName, email, password, role);

        // Then
        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }

    // Additional tests for getters/setters and UserDetails interface methods can be added here
}
