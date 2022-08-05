package com.teamfresh.voc.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
	OK(200),
	BAD_REQUEST(400),
	NOT_FOUND(404);

	int statusCode;
	String code;

	StatusEnum(int statusCode) {
		this.statusCode = statusCode;
		this.code = name();
	}
}
