package com.abs.controller;
import com.abs.dto.AccountDTO;
import com.abs.dto.CustomerDTO;
import com.abs.service.AccountService;
import com.abs.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private AccountService accountService;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCustomer() {
        // Mock data
        CustomerDTO customerDTO = new CustomerDTO();
        HttpServletRequest request = mock(HttpServletRequest.class);

        // Mock service response
        ResponseEntity<CustomerDTO> expectedResponse = new ResponseEntity<>(customerDTO, HttpStatus.OK);
        when(customerService.addCustomer(customerDTO, request)).thenReturn(expectedResponse);

        // Call controller method
        ResponseEntity<CustomerDTO> actualResponse = customerController.addCustomer(customerDTO, request);

        // Verify
        assertEquals(expectedResponse, actualResponse);
        verify(customerService, times(1)).addCustomer(customerDTO, request);
    }
    
    @Test
    void deleteCustomerByEmail() {
        // Mock data
        String customerEmail = "test@example.com";
        CustomerDTO customerDTO = new CustomerDTO();

        // Mock service response
        ResponseEntity<CustomerDTO> expectedResponse = new ResponseEntity<>(customerDTO, HttpStatus.OK);
        when(customerService.deleteCustomer(customerEmail)).thenReturn(expectedResponse);

        // Call controller method
        ResponseEntity<CustomerDTO> actualResponse = customerController.deleteCustomerByEmail(customerEmail);

        // Verify
        assertEquals(expectedResponse, actualResponse);
        verify(customerService, times(1)).deleteCustomer(customerEmail);
    }

    // Write similar test methods for other controller endpoints
}
