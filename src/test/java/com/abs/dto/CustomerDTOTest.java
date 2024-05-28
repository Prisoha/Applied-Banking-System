package com.abs.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerDTOTest {

    @Test
    void testCustomerDTOBuilder() {
        // Given
        String customerFirstName = "John";
        String customerLastName = "Doe";
        String customerEmail = "john.doe@example.com";
        String customerPassword = "password";
        long contact = 1234567890L;

        // When
        CustomerDTO customerDTO = CustomerDTO.builder()
                .customerFirstName(customerFirstName)
                .customerLastName(customerLastName)
                .customerEmail(customerEmail)
                .customerPassword(customerPassword)
                .contact(contact)
                .build();

        // Then
        assertNotNull(customerDTO);
        assertEquals(customerFirstName, customerDTO.getCustomerFirstName());
        assertEquals(customerLastName, customerDTO.getCustomerLastName());
        assertEquals(customerEmail, customerDTO.getCustomerEmail());
        assertEquals(customerPassword, customerDTO.getCustomerPassword());
        assertEquals(contact, customerDTO.getContact());
    }

    // Additional tests for constructors, getters/setters, and custom methods can be added here
}
