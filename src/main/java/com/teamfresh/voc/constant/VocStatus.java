package com.teamfresh.voc.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * VOC 진행 상태
 */
@AllArgsConstructor
@Getter
@ToString
public enum VocStatus{
	REGISTRY("접수"),
	PROCEED("진행중"),
	CANCEL("취소"),
	END("완료");

	private String value;
}
