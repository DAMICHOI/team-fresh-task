package com.teamfresh.voc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
	OK(200, "요청이 성공했습니다."),
	NO_CONTENTS(204, "요청을 정상적으로 처리했으며, 응답할 내용이 없습니다."),
	INVALID_REQUEST(400, "잘못된 요청입니다."),
	NOT_FOUND(404,"대상을 찾을 수 없습니다."),
	INTERNAL_ERROR(500, "요청 처리중 문제가 발생하였습니다.");

	private int statusCode;
	private String message;
}
