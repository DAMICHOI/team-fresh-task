package com.teamfresh.voc.dto;

import com.teamfresh.voc.constant.VocStatus;
import com.teamfresh.voc.constant.VocType;
import com.teamfresh.voc.domain.Carrier;
import com.teamfresh.voc.domain.Customer;
import com.teamfresh.voc.domain.Voc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VocRegistryDto {
	// 고객사 정보
	private Long customer_id;

	// 귀책 당사자
	private VocType vocType;

	// 운송사 정보
	private Long carrier_id;

	// voc 정보
	private String contents;

	public Voc toVoc() {
		return Voc.builder()
			.type(vocType)
			.contents(contents)
			.status(VocStatus.REGISTRY)
			.customer(new Customer(customer_id))
			.carrier(new Carrier(carrier_id))
			.build();
	}
}
