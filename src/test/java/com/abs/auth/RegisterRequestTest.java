package com.abs.auth;

import com.abs.model.Role;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RegisterRequestTest {

    @Test
    void testNoArgsConstructor() {
        RegisterRequest request = new RegisterRequest();
        assertNotNull(request);
    }

    @Test
    void testAllArgsConstructor() {
        RegisterRequest request = new RegisterRequest("John", "Doe", "john@example.com", "password", Role.MANAGER);
        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("john@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.MANAGER, request.getRole());
    }

    @Test
    void testGettersAndSetters() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john@example.com");
        request.setPassword("password");
        request.setRole(Role.MANAGER);
        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("john@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.MANAGER, request.getRole());
    }

    @Test
    void testBuilder() {
        RegisterRequest request = RegisterRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("password")
                .role(Role.MANAGER)
                .build();
        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("john@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
        assertEquals(Role.MANAGER, request.getRole());
    }
}
