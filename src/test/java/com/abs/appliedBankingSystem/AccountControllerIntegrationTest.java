package com.abs.appliedBankingSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.abs.dto.AccountDTO;
import com.abs.model.AccountType;
import com.abs.model.Customer;
import com.abs.model.Response;
import com.abs.repository.CustomerRepository;
import com.abs.utility.RestTemplateConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = { "classpath:TestDB/schema.sql", "classpath:TestDB/InsertStatements.sql" })
class AccountControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private static final Logger logger = LoggerFactory.getLogger(AccountControllerIntegrationTest.class);
    private static RestTemplate restTemplate;
    private String baseURL = "http://localhost:";
    private static String JwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYW5lc2hAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOiJyZWFkLGNyZWF0ZSx1cGRhdGUsUk9MRV9NQU5BR0VSLGRlbGV0ZSIsImlhdCI6MTcxNjQ2NDk0NSwiZXhwIjoxNzE2OTgzMzQ1fQ.Yp2h6Uqtpq0kwzw17x8SIuBX1dZI4xzXoJgweuN49BA";


    @Autowired
    private CustomerRepository customerRepository;

    @BeforeAll
    public static void init() {
    	RestTemplateConfiguration config = new RestTemplateConfiguration(); 
        restTemplate = config.restTemplateWithJwt(JwtToken);
    }

    @BeforeEach
    public void setup() {
        logger.info("The default port for the server is: {}", port);
        
    }

    private static final int ACCOUNT_NUMBER = 787645;
    
    private static final double ACCOUNT_BALANCE = 1000;
    
    private static final AccountType ACCOUNT_TYPE = AccountType.SAVINGS;
    
    public static final String CUSTOMER_EMAIL = "ganesh@gmail.com"; 
    
    private static final LocalDateTime DATE=LocalDateTime.now();
    
    @Test
    void openAcccountSuccessCase() {
    	baseURL = baseURL.concat(port + "/customer").concat("/account/" + CUSTOMER_EMAIL);
    	
    	AccountDTO accountDto = AccountDTO.builder().accountNumber(ACCOUNT_NUMBER)
    												.accountBalance(ACCOUNT_BALANCE)
    			                                    .accountType(ACCOUNT_TYPE)
    			                                    .openedDate(DATE)
    			                                    .build();
    	
     	ResponseEntity<AccountDTO> entity = restTemplate.postForEntity(baseURL, accountDto, AccountDTO.class);
    	
    	assertNotNull(entity.getBody());
    	assertEquals(accountDto.getAccountBalance(), entity.getBody().getAccountBalance());
    }
    

    
    	@Test
    	void closeAccountSuccessCase() {
    	int accountId = 1;
       // Define the URL for the close account endpoint
        baseURL = baseURL.concat(port + "/customer").concat("/deleteAccount/" + accountId);
////
////        // Send a request to the endpoint to close the account
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(JwtToken);
        HttpEntity<AccountDTO> request = new HttpEntity<>(headers);
        ResponseEntity<AccountDTO> response = restTemplate.exchange(baseURL, HttpMethod.DELETE, request, AccountDTO.class);
////
////        // Verify that the response status is OK (200)
       	assertEquals(HttpStatus.OK, response.getStatusCode());
////
////        // Optionally, verify additional details in the response if applicable
    	}
//
//  
    }
    	
