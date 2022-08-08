package com.teamfresh.voc.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> extends BasicResponse {
	private int statusCode;
	private String message;
	private T data;

	public SuccessResponse() {
		this.statusCode = ResponseCode.NO_CONTENTS.getStatusCode();
		this.message = ResponseCode.NO_CONTENTS.getMessage();
		this.data = null;
	}

	public SuccessResponse(T data) {
		this.statusCode = ResponseCode.OK.getStatusCode();
		this.message = ResponseCode.OK.getMessage();
		this.data = data;
	}
}
