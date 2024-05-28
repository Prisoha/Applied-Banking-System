package com.abs.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void testAccountBuilder() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Account account = Account.builder()
                .accountId(1)
                .accountNumber(123456789)
                .accountBalance(1000.0)
                .accountType(AccountType.SAVINGS)
                .openedDate(now)
                .addedby("admin")
                .addedOn(now)
                .updateBy("admin")
                .updateOn(now)
                .customer(customer)
                .build();

        assertNotNull(account);
        assertEquals(1, account.getAccountId());
        assertEquals(123456789, account.getAccountNumber());
        assertEquals(1000.0, account.getAccountBalance());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
        assertEquals(now, account.getOpenedDate());
        assertEquals("admin", account.getAddedby());
        assertEquals(now, account.getAddedOn());
        assertEquals("admin", account.getUpdateBy());
        assertEquals(now, account.getUpdateOn());
        assertEquals(customer, account.getCustomer());
    }

    @Test
    void testAccountNoArgsConstructor() {
        Account account = new Account();
        assertNotNull(account);
    }

    @Test
    void testAccountAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Account account = new Account(1, 123456789, 1000.0, AccountType.SAVINGS, now, "admin", now, "admin", now, customer);

        assertNotNull(account);
        assertEquals(1, account.getAccountId());
        assertEquals(123456789, account.getAccountNumber());
        assertEquals(1000.0, account.getAccountBalance());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
        assertEquals(now, account.getOpenedDate());
        assertEquals("admin", account.getAddedby());
        assertEquals(now, account.getAddedOn());
        assertEquals("admin", account.getUpdateBy());
        assertEquals(now, account.getUpdateOn());
        assertEquals(customer, account.getCustomer());
    }

    @Test
    void testSettersAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerFirstName("John");
        customer.setCustomerLastName("Doe");
        customer.setCustomerEmail("john.doe@example.com");

        Account account = new Account();
        account.setAccountId(1);
        account.setAccountNumber(123456789);
        account.setAccountBalance(1000.0);
        account.setAccountType(AccountType.SAVINGS);
        account.setOpenedDate(now);
        account.setAddedby("admin");
        account.setAddedOn(now);
        account.setUpdateBy("admin");
        account.setUpdateOn(now);
        account.setCustomer(customer);

        assertEquals(1, account.getAccountId());
        assertEquals(123456789, account.getAccountNumber());
        assertEquals(1000.0, account.getAccountBalance());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
        assertEquals(now, account.getOpenedDate());
        assertEquals("admin", account.getAddedby());
        assertEquals(now, account.getAddedOn());
        assertEquals("admin", account.getUpdateBy());
        assertEquals(now, account.getUpdateOn());
        assertEquals(customer, account.getCustomer());
    }
}
