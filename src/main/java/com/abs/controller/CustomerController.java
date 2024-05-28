package com.abs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.abs.dto.AccountDTO;
import com.abs.dto.CustomerDTO;
import com.abs.model.Response;
import com.abs.service.AccountService;
import com.abs.service.AddressService;
import com.abs.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	
	AccountService accountService;


	@Autowired
	CustomerService customerService;

	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDto, HttpServletRequest request) {
		return customerService.addCustomer(customerDto, request);
	}

	@DeleteMapping("/deleteCustomer/{customerEmail}")
	public ResponseEntity<CustomerDTO> deleteCustomerByEmail(
			@PathVariable(name = "customerEmail") String customerEmail) {
		return customerService.deleteCustomer(customerEmail);
	}

	@PostMapping("/account/{customerEmail}")
	public ResponseEntity<AccountDTO> openAccount(@RequestBody AccountDTO accountDto,
			@PathVariable(name = "customerEmail") String customerEmail) {
		return accountService.openAccount(accountDto, customerEmail);
	}

	@DeleteMapping("/deleteAccount/{accountId}")
	public ResponseEntity<AccountDTO> closeAccount(@PathVariable(name = "accountId") int accountId) {
		return accountService.closeAccount(accountId);
	}

}
