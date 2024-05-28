package com.abs.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class AddressDTOTest {

    @Test
    void testAddressDTOConstructor() {
        // Given
        int addressId = 1;
        String addressLine = "123 Main Street";
        String customerState = "State";
        String customerCountry = "Country";
        String addedBy = "Admin";
        LocalDateTime addedOn = LocalDateTime.now();
        String updatedBy = "Admin";
        LocalDateTime updatedOn = LocalDateTime.now();

        // When
        AddressDTO addressDTO = new AddressDTO(addressId, addressLine, customerState, customerCountry, addedBy, addedOn, updatedBy, updatedOn);

        // Then
        assertNotNull(addressDTO);
        assertEquals(addressId, addressDTO.getAddressId());
        assertEquals(addressLine, addressDTO.getAddressLine());
        assertEquals(customerState, addressDTO.getCustomerState());
        assertEquals(customerCountry, addressDTO.getCustomerCountry());
        assertEquals(addedBy, addressDTO.getAddedBy());
        assertEquals(addedOn, addressDTO.getAddedOn());
        assertEquals(updatedBy, addressDTO.getUpdatedBy());
        assertEquals(updatedOn, addressDTO.getUpdatedOn());
    }

    @Test
    void testAddressDTOBuilder() {
        // Given
        int addressId = 1;
        String addressLine = "123 Main Street";
        String customerState = "State";
        String customerCountry = "Country";
        String addedBy = "Admin";
        LocalDateTime addedOn = LocalDateTime.now();
        String updatedBy = "Admin";
        LocalDateTime updatedOn = LocalDateTime.now();

        // When
        AddressDTO addressDTO = AddressDTO.builder()
                .addressId(addressId)
                .addressLine(addressLine)
                .customerState(customerState)
                .customerCountry(customerCountry)
                .addedBy(addedBy)
                .addedOn(addedOn)
                .updatedBy(updatedBy)
                .updatedOn(updatedOn)
                .build();

        // Then
        assertNotNull(addressDTO);
        assertEquals(addressId, addressDTO.getAddressId());
        assertEquals(addressLine, addressDTO.getAddressLine());
        assertEquals(customerState, addressDTO.getCustomerState());
        assertEquals(customerCountry, addressDTO.getCustomerCountry());
        assertEquals(addedBy, addressDTO.getAddedBy());
        assertEquals(addedOn, addressDTO.getAddedOn());
        assertEquals(updatedBy, addressDTO.getUpdatedBy());
        assertEquals(updatedOn, addressDTO.getUpdatedOn());
    }

    // Additional tests for custom methods can be added here
}
