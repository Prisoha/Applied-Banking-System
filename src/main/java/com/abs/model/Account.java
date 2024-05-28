package com.abs.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int accountId;
		private int accountNumber;
		private double accountBalance;
		@Enumerated(EnumType.STRING)
		private AccountType accountType;
		private LocalDateTime openedDate;
		private String addedby;
		private LocalDateTime addedOn;
		private String updateBy;
		private LocalDateTime updateOn;
		@ManyToOne
		Customer customer;
		
}
