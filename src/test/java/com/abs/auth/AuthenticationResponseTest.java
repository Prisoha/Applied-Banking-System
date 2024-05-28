package com.abs.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {

    @Test
    void testNoArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse();
        assertNotNull(response);
    }

    @Test
    void testAllArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse("accessToken");
        assertEquals("accessToken", response.getAccessToken());
    }

    @Test
    void testGettersAndSetters() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setAccessToken("accessToken");
        assertEquals("accessToken", response.getAccessToken());
    }

    @Test
    void testBuilder() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .accessToken("accessToken")
                .build();
        assertEquals("accessToken", response.getAccessToken());
    }
}
