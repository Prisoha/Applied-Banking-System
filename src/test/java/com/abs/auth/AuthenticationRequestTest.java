package com.abs.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthenticationRequestTest {

    @Test
    void testNoArgsConstructor() {
        AuthenticationRequest request = new AuthenticationRequest();
        assertNotNull(request);
    }

    @Test
    void testAllArgsConstructor() {
        AuthenticationRequest request = new AuthenticationRequest("test@example.com", "password");
        assertEquals("test@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testGettersAndSetters() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setEmail("test@example.com");
        request.setPassword("password");
        assertEquals("test@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testBuilder() {
        AuthenticationRequest request = AuthenticationRequest.builder()
                .email("test@example.com")
                .password("password")
                .build();
        assertEquals("test@example.com", request.getEmail());
        assertEquals("password", request.getPassword());
    }
}
