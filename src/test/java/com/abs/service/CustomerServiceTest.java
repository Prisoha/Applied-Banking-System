package com.abs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.abs.dto.CustomerDTO;
import com.abs.model.Customer;
import com.abs.model.User;
import com.abs.repository.CustomerRepository;
import com.abs.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private HttpServletRequest request;

    private CustomerDTO customerDto;
    private Customer customer;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerDto = CustomerDTO.builder()
                .customerFirstName("John")
                .customerLastName("Doe")
                .customerEmail("john.doe@example.com")
                .customerPassword("password")
                .contact(1234567890L)
                .build();

        customer = new Customer();
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");
        customer.setCustomerPassword("password");
        customer.setContact(1234567890L);

        user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
    }

    @Test
    void testAddCustomer() {
        // Mocking the request to return a specific header
        when(request.getHeader(HttpHeaders.AUTHORIZATION)).thenReturn("Bearer dummyJwtToken");

        // Mocking jwtService to return a specific username
        when(jwtService.extractUsername("dummyJwtToken")).thenReturn("john.doe@example.com");

        // Mocking userRepository to return a specific user
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(Optional.of(user));

        // Mocking customerRepository to save the customer and return it
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        // Calling the method under test
        ResponseEntity<CustomerDTO> response = customerService.addCustomer(customerDto, request);

        // Verifying interactions
        verify(request, times(1)).getHeader(HttpHeaders.AUTHORIZATION);
        verify(jwtService, times(1)).extractUsername("dummyJwtToken");
        verify(userRepository, times(1)).findByEmail("john.doe@example.com");
        verify(customerRepository, times(1)).save(any(Customer.class));

        // Verifying the response
//        assertEquals(ResponseEntity.ok(customerDto), response);
    }
    @Test
    void testDeleteCustomer() {
        // Mocking the customer
        Customer customer = new Customer();
        customer.setCustomerEmail("test@example.com");

        // Mocking customerRepository to return a specific customer
        when(customerRepository.findByCustomerEmail("test@example.com")).thenReturn(Optional.of(customer));

        // Calling the method under test
        ResponseEntity<CustomerDTO> response = customerService.deleteCustomer("test@example.com");

        // Verifying interactions
        verify(customerRepository, times(1)).findByCustomerEmail("test@example.com");
        verify(customerRepository, times(1)).delete(customer);

        // Verifying the response
        assertNotNull(response);
//        assertEquals(ResponseEntity.ok().build(), response);

        // Ensure the customer is deleted
        verify(customerRepository, times(1)).delete(customer);
    }

    @Test
    void testDeleteCustomer_CustomerNotFound() {
        // Mocking customerRepository to return an empty optional
        when(customerRepository.findByCustomerEmail(anyString())).thenReturn(Optional.empty());

        // Calling the method under test and expecting an exception
        assertThrows(RuntimeException.class, () -> customerService.deleteCustomer("nonexistent@example.com"));

        // Verifying interactions
        verify(customerRepository, times(1)).findByCustomerEmail("nonexistent@example.com");
        verify(customerRepository, never()).delete(any());
    }
}


