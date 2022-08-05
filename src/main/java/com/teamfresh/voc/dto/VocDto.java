package com.teamfresh.voc.dto;

import java.io.Serializable;

import com.teamfresh.voc.constant.VocStatus;
import com.teamfresh.voc.constant.VocType;
import com.teamfresh.voc.domain.Carrier;
import com.teamfresh.voc.domain.Customer;
import com.teamfresh.voc.domain.Penalty;
import com.teamfresh.voc.domain.Reparation;
import com.teamfresh.voc.domain.Voc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class VocDto implements Serializable {
	private Long id;
	private VocType type;
	private String contents;
	private VocStatus status;
	private CustomerDto customer;
	private CarrierDto carrier;
	private PenaltyDto penalty;
	private ReparationDto reparation;

	public VocDto(Long id, VocType value, String contents, VocStatus status, Customer customer, Carrier carrier,
		Penalty penalty, Reparation reparation) {
		this.id = id;
		this.type = value;
		this.contents = contents;
		this.status = status;
		this.customer = CustomerDto.from(customer);
		this.carrier = CarrierDto.from(carrier);
		this.penalty = PenaltyDto.from(penalty);
	}

	public VocDto form(Voc voc) {
		return new VocDto(
			voc.getId(),
			voc.getType(),
			voc.getContents(),
			voc.getStatus(),
			voc.getCustomer(),
			voc.getCarrier(),
			voc.getPenalty(),
			voc.getReparation()
		);
	}
}
