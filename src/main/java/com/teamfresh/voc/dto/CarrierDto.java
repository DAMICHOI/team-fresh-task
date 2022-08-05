package com.teamfresh.voc.dto;

import java.io.Serializable;

import com.teamfresh.voc.domain.Carrier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CarrierDto implements Serializable {
	private Long id;
	private String carrier_name;
	private String company_name;

	public static CarrierDto from(Carrier carrier) {
		return new CarrierDto(
			carrier.getId(),
			carrier.getCarrier_name(),
			carrier.getCarrier_name()
		);
	}
}
