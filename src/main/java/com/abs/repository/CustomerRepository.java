package com.abs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abs.dto.AccountDTO;
import com.abs.model.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByCustomerEmail(String customerEmail);

//	AccountDTO saveAccountDetails(AccountDTO accountDTO);

//	Optional<Customer> findByFirstNameAndLastName(String customerFirstName, String customerLastName);

//	Optional<Customer> findByCustomerEmail(String customerEmail);
	

}
