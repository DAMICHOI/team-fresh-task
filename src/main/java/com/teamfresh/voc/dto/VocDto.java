package com.teamfresh.voc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.teamfresh.voc.constant.VocStatus;
import com.teamfresh.voc.constant.VocType;
import com.teamfresh.voc.domain.Carrier;
import com.teamfresh.voc.domain.Customer;
import com.teamfresh.voc.domain.Penalty;
import com.teamfresh.voc.domain.Reparation;
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
public class VocDto implements Serializable {
	private Long id;
	private VocType type;		// 귀책당사자
	private String contents;	// 귀책 내용
	private boolean is_confirm;	// 기사 확인 여부
	private boolean is_objection;	// 이의제기 여부
	private BigDecimal amount;	// 배상 금액

	public VocDto(Long id, VocType type, String contents, Penalty penalty, Reparation reparation) {
		this.id = id;
		this.type = type;
		this.contents = contents;
		this.is_confirm = false;
		this.is_objection = false;
		this.amount=null;
	}

	/**
	 * VOC Entity 를 DTO 로 변환
	 * @param voc VOC Entity
	 * @return 변환된 VOC DTO
	 */
	public static VocDto from(Voc voc) {
		return new VocDto(
			voc.getId(),
			voc.getType(),
			voc.getContents(),
			// voc.getPenalty().getIs_confirm(),
			// voc.getPenalty().getIs_objection(),
			// voc.getReparation().getAmount(),
			voc.getPenalty(),
			voc.getReparation()
		);
	}
}
