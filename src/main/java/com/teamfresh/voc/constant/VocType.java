package com.teamfresh.voc.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 귀책 당사자
 */
@AllArgsConstructor
@Getter
@ToString
public enum VocType{
	CARRIER("운송사"), CUSTOMER("고객사");

	private String value;
}
