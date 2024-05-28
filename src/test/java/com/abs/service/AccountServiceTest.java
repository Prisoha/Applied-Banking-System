package com.abs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.abs.dto.AccountDTO;
import com.abs.exception.CustomException;
import com.abs.model.Account;
import com.abs.model.AccountType;
import com.abs.model.Customer;
import com.abs.model.Response;
import com.abs.repository.AccountRepository;
import com.abs.repository.CustomerRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class AccountServiceTest {

   

    @Mock
    private CustomerRepository customerRepository;
    
    @Mock
    
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImplementation accountService;
    @Test
    public void openAccount_CustomerNotFound() throws Exception {
    	
    	String customerEmail = "test@example.com";
        AccountDTO accountDto = new AccountDTO();
        Mockito.when(customerRepository.findByCustomerEmail(customerEmail)).thenReturn(Optional.empty());
        ResponseEntity<AccountDTO> responseEntity = accountService.openAccount(accountDto, customerEmail);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        
        Mockito.verify(customerRepository, Mockito.times(1)).findByCustomerEmail(customerEmail);
    	}
    @Test
    public void openAccount() throws Exception {
    	String customerEmail = "test@example.com";
        AccountDTO accountDto = new AccountDTO();
        accountDto.setAccountNumber(1234567890);
        accountDto.setAccountBalance(1000.00);
        accountDto.setAccountType(AccountType.SAVINGS);
        
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(1);
        mockCustomer.setCustomerFirstName("John");
        mockCustomer.setCustomerLastName("Gupta");
        mockCustomer.setCustomerEmail(customerEmail);
        mockCustomer.setAccounts(new ArrayList<>());
        
        Mockito.when(customerRepository.findByCustomerEmail(customerEmail)).thenReturn(Optional.of(mockCustomer));

        Account mockAccount = new Account();
        mockAccount.setAccountNumber(accountDto.getAccountNumber());
        mockAccount.setAccountBalance(accountDto.getAccountBalance());
        mockAccount.setAccountType(accountDto.getAccountType());
        mockAccount.setOpenedDate(LocalDateTime.now());
        mockAccount.setCustomer(mockCustomer);
        
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(mockAccount);
        ResponseEntity<AccountDTO> responseEntity = accountService.openAccount(accountDto, customerEmail);
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        
        AccountDTO responseAccountDto = responseEntity.getBody();
        assertEquals(accountDto.getAccountNumber(), responseAccountDto.getAccountNumber());
        assertEquals(accountDto.getAccountBalance(), responseAccountDto.getAccountBalance());
        assertEquals(accountDto.getAccountType(), responseAccountDto.getAccountType());

        Mockito.verify(customerRepository, Mockito.times(1)).findByCustomerEmail(customerEmail);
        Mockito.verify(accountRepository, Mockito.times(1)).save(Mockito.any(Account.class));
    	}
    
    @Test
    public void closeAccount_Success() {
        int accountId = 1;
        Account mockAccount = new Account();
        mockAccount.setAccountId(accountId);
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(mockAccount));

        ResponseEntity<AccountDTO> response = accountService.closeAccount(accountId);
        
        verify(accountRepository, times(1)).delete(mockAccount);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void closeAccount_AccountNotFound() {
        int accountId = 1;

        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class, () -> {
            accountService.closeAccount(accountId);
        });

        assertEquals("account Id not found", exception.getMessage());
        verify(accountRepository, never()).delete(any(Account.class));
    }
}