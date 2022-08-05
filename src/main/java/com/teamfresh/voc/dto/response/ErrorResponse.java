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

	public ErrorResponse(ResponseCode code) {
		this.code = code.getStatusCode();
		this.message = code.getMessage();
	}

}