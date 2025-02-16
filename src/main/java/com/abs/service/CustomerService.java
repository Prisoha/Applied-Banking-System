package com.abs.service;

import java.time.LocalDateTime;
import java.util.Optional;
import com.abs.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abs.dto.CustomerDTO;
import com.abs.model.Customer;
import com.abs.repository.CustomerRepository;
import com.abs.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomerService {

	
		private CustomerRepository customerRepository;
		private UserRepository userRepository;
		private JwtService jwtService;
		
	public ResponseEntity<CustomerDTO> addCustomer(CustomerDTO customerDto, HttpServletRequest request) {
		
		Customer customer = mapToCustomer(customerDto);
		
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String email;
		
		jwt = authHeader.substring(7);
		
		email = jwtService.extractUsername(jwt);
		 Optional<User> user = userRepository.findByEmail(email);
		
		customer.setAddedBy(user.get().getFirstName()+" "+user.get().getLastName());
		customer.setUpdatedBy(user.get().getFirstName()+" "+user.get().getLastName());
		
		return ResponseEntity.ok(mapToCustomerDTO(customerRepository.save(customer)));
	}

	
		private CustomerDTO mapToCustomerDTO(Customer customer) {
			return CustomerDTO.builder()
					.customerFirstName(customer.getCustomerFirstName())
					.customerLastName(customer.getCustomerLastName())
					.customerEmail(customer.getCustomerEmail())
					.customerPassword(customer.getCustomerPassword())
					.contact(customer.getContact())
					.build();
		}
		


		private Customer mapToCustomer(CustomerDTO customerDto) {
			
			return Customer.builder().customerFirstName(customerDto.getCustomerFirstName())
									.customerLastName(customerDto.getCustomerLastName())
									.customerEmail(customerDto.getCustomerEmail())
									.customerPassword(customerDto.getCustomerPassword())
									.contact(customerDto.getContact())
									.addedOn(LocalDateTime.now())
									.updatedOn(LocalDateTime.now())
									.build();
		}


		public ResponseEntity<CustomerDTO> deleteCustomer(String customerEmail) {
			
			Optional<Customer> optional = customerRepository.findByCustomerEmail(customerEmail);
			
			if(optional.isPresent()) {
				Customer customer = optional.get();
				customerRepository.delete(customer);
				return ResponseEntity.ok(mapToCustomerDTO(customer));
			}
			else
				throw new RuntimeException("Customer Not Found by email: " + customerEmail);
		}

}

