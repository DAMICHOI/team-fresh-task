package com.teamfresh.voc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.teamfresh.voc.domain.Penalty;
import com.teamfresh.voc.domain.Voc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PenaltyDto implements Serializable {
	private Long id;
	private Long voc_id;
	private boolean is_confirm;
	private boolean is_objection;

	public static PenaltyDto from(Penalty penalty, Voc voc) {
		return new PenaltyDto(
			penalty.getId(),
			voc.getId(),
			penalty.is_confirm(),
			penalty.is_objection()
		);
	}

	public Penalty toPenalty(Voc voc) {
		return Penalty.builder()
			.id(id)
			.voc(voc)
			.is_confirm(false)
			.is_objection(false)
			.build();
	}
}
