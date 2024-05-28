package com.abs.auth;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RegisterResponseTest {

    @Test
    void testNoArgsConstructor() {
        RegisterResponse response = new RegisterResponse();
        assertNotNull(response);
    }

    @Test
    void testAllArgsConstructor() {
        RegisterResponse response = new RegisterResponse(1, "john@example.com", "password");
        assertEquals(1, response.getId());
        assertEquals("john@example.com", response.getEmail());
        assertEquals("password", response.getPassword());
    }

    @Test
    void testGettersAndSetters() {
        RegisterResponse response = new RegisterResponse();
        response.setId(1);
        response.setEmail("john@example.com");
        response.setPassword("password");
        assertEquals(1, response.getId());
        assertEquals("john@example.com", response.getEmail());
        assertEquals("password", response.getPassword());
    }

    @Test
    void testBuilder() {
        RegisterResponse response = RegisterResponse.builder()
                .id(1)
                .email("john@example.com")
                .password("password")
                .build();
        assertEquals(1, response.getId());
        assertEquals("john@example.com", response.getEmail());
        assertEquals("password", response.getPassword());
    }
}
