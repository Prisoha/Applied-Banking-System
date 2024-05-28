package com.abs.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abs.dto.AccountDTO;
import com.abs.exception.CustomException;
import com.abs.model.Account;
import com.abs.model.Customer;
import com.abs.repository.AccountRepository;
import com.abs.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImplementation implements AccountService {

	private final CustomerRepository customerRepository;
	private final AccountRepository accountRepository;


	private Account mapToAccount(AccountDTO accountDTO) {

		return Account.builder().accountNumber(accountDTO.getAccountNumber())
				.accountBalance(accountDTO.getAccountBalance()).accountType(accountDTO.getAccountType())
				.openedDate(LocalDateTime.now()).build();
	}

	private AccountDTO mapToAccountDto(Account account) {


		return AccountDTO.builder().accountNumber(account.getAccountNumber())
				.accountBalance(account.getAccountBalance()).accountType(account.getAccountType())
				.openedDate(LocalDateTime.now()).build();
	}

	public ResponseEntity<AccountDTO> closeAccount(int accountId) {

		Optional<Account> optional = accountRepository.findById(accountId);

		if (optional.isPresent()) {
			Account account = optional.get();
			accountRepository.delete(account);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new CustomException("account Id not found");
		}
	}

	@Override
	public ResponseEntity<AccountDTO> openAccount(AccountDTO accountDto, String customerEmail) {
		Account account = mapToAccount(accountDto);

		Optional<Customer> optional = customerRepository.findByCustomerEmail(customerEmail);

		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		Customer customer = optional.get();

		customer.getAccounts().add(account);
		account.setCustomer(customer);

		customerRepository.save(customer);
		Account savedAccount = accountRepository.save(account);

		AccountDTO savedAccountDTO = mapToAccountDto(savedAccount);

		return ResponseEntity.ok(savedAccountDTO);
	}


}