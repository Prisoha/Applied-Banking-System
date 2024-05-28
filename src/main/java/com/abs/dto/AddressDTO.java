package com.abs.dto;

import java.time.LocalDateTime;

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
public class AddressDTO {
	
	private int addressId;
	private String addressLine;
	private String customerState;
	private String customerCountry;
	private String addedBy;
	private LocalDateTime addedOn;
	private String updatedBy;
	private LocalDateTime updatedOn;

}
