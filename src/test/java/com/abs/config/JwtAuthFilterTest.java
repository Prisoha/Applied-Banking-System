package com.abs.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.abs.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class JwtAuthFilterTest {

	@InjectMocks
	JwtAuthFilter authFilter;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void testUserNotFoundInDatabase() {
	    // Mock HttpServletRequest, HttpServletResponse, FilterChain, and other dependencies

	    // Set up a valid JWT token in the Authorization header
	    //when(request.getHeader("Authorization")).thenReturn("Bearer valid_jwt_token");

	    // Mock jwtService.extractUsername(jwt) to return a valid email
	   // when(jwtService.extractUsername("valid_jwt_token")).thenReturn("test@example.com");

	    // Mock userDetailsService.loadUserByUsername(email) to return null, indicating user not found
	  //  when(userDetailsService.loadUserByUsername("test@example.com")).thenReturn(null);

	    // Perform filter execution

	    // Verify that filter chain proceeds without authentication
	    //verify(filterChain, times(1)).doFilter(request, response);
	}

}
