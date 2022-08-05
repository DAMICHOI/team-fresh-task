package com.teamfresh.voc.dto;

import java.io.Serializable;

import com.teamfresh.voc.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {
	private Long id;
	private String company_name;
	private String manager_name;
	private String contact;

	public static CustomerDto from(Customer customer) {
		return new CustomerDto(
			customer.getId(),
			customer.getCompany_name(),
			customer.getManager_name(),
			customer.getContact()
		);
	}
}
