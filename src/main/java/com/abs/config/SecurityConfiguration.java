package com.abs.config;

import static com.abs.model.Role.HELPDESK;
import static com.abs.model.Role.MANAGER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

	private final AuthenticationProvider authenticationProvider;
	private final JwtAuthFilter jwtAuthFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
							.authorizeHttpRequests(req -> req.requestMatchers("/auth/*").permitAll()
									
									
									
									.requestMatchers(POST,"/customer/**").hasAnyRole(MANAGER.name(),HELPDESK.name())
									.requestMatchers(DELETE,"/customer/**").hasAnyRole(MANAGER.name())
									.anyRequest().authenticated())
									.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
									.authenticationProvider(authenticationProvider)
									.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
								
				
	}

}
