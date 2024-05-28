package com.abs.service;

import org.springframework.http.ResponseEntity;

import com.abs.dto.AccountDTO;




public interface AccountService {


	ResponseEntity<AccountDTO> openAccount(AccountDTO accountDto, String customerEmail);

	ResponseEntity<AccountDTO> closeAccount(int accountId);
}
