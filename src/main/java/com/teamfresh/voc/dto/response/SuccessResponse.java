package com.teamfresh.voc.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> extends BasicResponse {
	private int statusCode;
	private String message;
	private int count;
	private T data;

	public SuccessResponse() {
		this.statusCode = ResponseCode.NO_CONTENTS.getStatusCode();
		this.message = ResponseCode.NO_CONTENTS.getMessage();
		this.count = 0;
		this.data = null;
	}

	public SuccessResponse(T data) {
		this.statusCode = ResponseCode.OK.getStatusCode();
		this.data = data;
		if (data instanceof List) {
			this.count = ((List<T>)data).size();
		} else {
			this.count = 1;
		}
	}
}
