package com.abs.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testCustomerBuilder() {
        LocalDateTime now = LocalDateTime.now();
        
        Address address1 = new Address();
        address1.setAddressId(1);
        Address address2 = new Address();
        address2.setAddressId(2);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        
        Account account1 = new Account();
        account1.setAccountId(1);
        Account account2 = new Account();
        account2.setAccountId(2);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        Customer customer = Customer.builder()
                .customerId(1)
                .customerFirstName("John")
                .customerLastName("Doe")
                .customerEmail("john.doe@example.com")
                .customerPassword("password")
                .contact(1234567890)
                .addedBy("admin")
                .addedOn(now)
                .updatedBy("admin")
                .updatedOn(now)
                .addresses(addresses)
                .accounts(accounts)
                .build();

        assertNotNull(customer);
        assertEquals(1, customer.getCustomerId());
        assertEquals("John", customer.getCustomerFirstName());
        assertEquals("Doe", customer.getCustomerLastName());
        assertEquals("john.doe@example.com", customer.getCustomerEmail());
        assertEquals("password", customer.getCustomerPassword());
        assertEquals(1234567890, customer.getContact());
        assertEquals("admin", customer.getAddedBy());
        assertEquals(now, customer.getAddedOn());
        assertEquals("admin", customer.getUpdatedBy());
        assertEquals(now, customer.getUpdatedOn());
        assertEquals(addresses, customer.getAddresses());
        assertEquals(accounts, customer.getAccounts());
    }

    // Additional tests for constructors and getters/setters can be added here
}
