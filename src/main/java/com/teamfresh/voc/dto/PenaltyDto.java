package com.teamfresh.voc.dto;

import java.io.Serializable;

import com.teamfresh.voc.domain.Penalty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PenaltyDto implements Serializable {
	private Long id;
	private boolean is_confirm;
	private boolean is_objection;

	public static PenaltyDto from(Penalty penalty) {
		return new PenaltyDto(
			penalty.getId(),
			penalty.is_confirm(),
			penalty.is_objection()
		);
	}
}
