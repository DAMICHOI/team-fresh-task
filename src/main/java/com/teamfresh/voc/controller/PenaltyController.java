package com.teamfresh.voc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc.dto.PenaltyDto;
import com.teamfresh.voc.dto.RequestPenaltyDto;
import com.teamfresh.voc.dto.response.BasicResponse;
import com.teamfresh.voc.dto.response.ErrorResponse;
import com.teamfresh.voc.dto.response.ResponseCode;
import com.teamfresh.voc.dto.response.SuccessResponse;
import com.teamfresh.voc.exception.VocException;
import com.teamfresh.voc.service.PenaltyService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/penalty")
@RequiredArgsConstructor
public class PenaltyController {
	private final PenaltyService penaltyService;

	@ApiOperation(
		value = "패널티 등록",
		notes = "패널티를 등록한다."
	)
	@PostMapping
	public BasicResponse create(@RequestBody RequestPenaltyDto requestPenaltyDto) {
		PenaltyDto penaltyDto;

		try {
			penaltyDto = penaltyService.save(requestPenaltyDto);

			if (penaltyDto == null) {
				return new ErrorResponse(ResponseCode.INTERNAL_ERROR, "");
			}

		} catch (VocException e) {
			return new ErrorResponse(ResponseCode.INVALID_REQUEST, e.getMessage());
		}
		return new SuccessResponse<>(penaltyDto);
	}
}
