package com.abs.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void testAddressBuilder() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Address address = Address.builder()
                .addressId(1)
                .addressLine("123 Main St")
                .customerState("CA")
                .customerCountry("USA")
                .addedBy("admin")
                .addedOn(now)
                .updatedBy("admin")
                .updatedOn(now)
                .customer(customer)
                .build();

        assertNotNull(address);
        assertEquals(1, address.getAddressId());
        assertEquals("123 Main St", address.getAddressLine());
        assertEquals("CA", address.getCustomerState());
        assertEquals("USA", address.getCustomerCountry());
        assertEquals("admin", address.getAddedBy());
        assertEquals(now, address.getAddedOn());
        assertEquals("admin", address.getUpdatedBy());
        assertEquals(now, address.getUpdatedOn());
        assertEquals(customer, address.getCustomer());
    }

    @Test
    void testAddressNoArgsConstructor() {
        Address address = new Address();
        assertNotNull(address);
    }

    @Test
    void testAddressAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Address address = new Address(1, "123 Main St", "CA", "USA", "admin", now, "admin", now, customer);

        assertNotNull(address);
        assertEquals(1, address.getAddressId());
        assertEquals("123 Main St", address.getAddressLine());
        assertEquals("CA", address.getCustomerState());
        assertEquals("USA", address.getCustomerCountry());
        assertEquals("admin", address.getAddedBy());
        assertEquals(now, address.getAddedOn());
        assertEquals("admin", address.getUpdatedBy());
        assertEquals(now, address.getUpdatedOn());
        assertEquals(customer, address.getCustomer());
    }

    @Test
    void testSettersAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Address address = new Address();
        address.setAddressId(1);
        address.setAddressLine("123 Main St");
        address.setCustomerState("CA");
        address.setCustomerCountry("USA");
        address.setAddedBy("admin");
        address.setAddedOn(now);
        address.setUpdatedBy("admin");
        address.setUpdatedOn(now);
        address.setCustomer(customer);

        assertEquals(1, address.getAddressId());
        assertEquals("123 Main St", address.getAddressLine());
        assertEquals("CA", address.getCustomerState());
        assertEquals("USA", address.getCustomerCountry());
        assertEquals("admin", address.getAddedBy());
        assertEquals(now, address.getAddedOn());
        assertEquals("admin", address.getUpdatedBy());
        assertEquals(now, address.getUpdatedOn());
        assertEquals(customer, address.getCustomer());
    }
}
