package com.abs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class JwtServiceTest {

	private static final String SECRET = "9a2f8c4e6b0d71f3e8b925a45747f894a3d6bc70fa8d5e21a15a6d8c3b9a0e7c";
    private static final String USERNAME = "testuser";
    private static final String TOKEN = "dummyToken";
//    
    @InjectMocks
    private JwtService jwtService;
    
    @Mock
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
    }

    @Test
    void testGenerateToken() {
        // Given
        UserDetails userDetails = new User("username", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));

        // When
        String token = jwtService.generateToken(userDetails);

        // Then
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    void testExtractUsername() {
        // Given
        String token = jwtService.generateToken(new User("username", "password", Collections.emptyList()));

        // When
        String extractedUsername = jwtService.extractUsername(token);

        // Then
        assertEquals("username", extractedUsername);
    }

   
    	
	    	@Test
	    	void testIsTokenValid_InvalidToken() {
    		JwtService spyJwtService = spy(jwtService);
	//
	        doReturn("invaliduser").when(spyJwtService).extractUsername(TOKEN);
	//
	        boolean isValid = spyJwtService.isTokenValid(TOKEN, userDetails);
	        assertFalse(isValid);
	 }
	//
    		
	}
	//
