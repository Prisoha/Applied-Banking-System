package com.abs.controller;

import com.abs.auth.AuthenticationRequest;
import com.abs.auth.AuthenticationResponse;
import com.abs.auth.RegisterRequest;
import com.abs.auth.RegisterResponse;
import com.abs.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthControllerTest {

    @Test
    void testRegister() {
        // Given
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService);
        RegisterRequest registerRequest = new RegisterRequest(/* provide necessary details */);
        RegisterResponse expectedResponse = new RegisterResponse(/* provide expected details */);
        when(authService.register(registerRequest)).thenReturn(expectedResponse);

        // When
        ResponseEntity<RegisterResponse> responseEntity = authController.register(registerRequest);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    void testAuthenticate() {
        // Given
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(/* provide necessary details */);
        AuthenticationResponse expectedResponse = new AuthenticationResponse(/* provide expected details */);
        when(authService.authenticate(authenticationRequest)).thenReturn(expectedResponse);

        // When
        ResponseEntity<AuthenticationResponse> responseEntity = authController.authenticate(authenticationRequest);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }
}
