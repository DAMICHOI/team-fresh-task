package com.teamfresh.voc.dto;

import com.teamfresh.voc.constant.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
	private StatusEnum status;
	private String message;
	private Object data;
}
