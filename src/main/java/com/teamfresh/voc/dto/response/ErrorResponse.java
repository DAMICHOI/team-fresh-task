package com.teamfresh.voc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends BasicResponse {
	private int code;
	private String message;
	private String detail;

	public ErrorResponse(ResponseCode code, String detail) {
		this.code = code.getStatusCode();
		this.message = code.getMessage();
		this.detail = detail;
	}

}