package com.abs.dto;

import java.time.LocalDateTime;

import com.abs.model.AccountType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
	
	private int accountNumber;
	private double accountBalance;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private LocalDateTime openedDate;
}
