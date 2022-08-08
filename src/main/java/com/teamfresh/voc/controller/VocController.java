package com.teamfresh.voc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc.dto.VocDto;
import com.teamfresh.voc.dto.VocRegistryDto;
import com.teamfresh.voc.dto.response.BasicResponse;
import com.teamfresh.voc.dto.response.ErrorResponse;
import com.teamfresh.voc.dto.response.ResponseCode;
import com.teamfresh.voc.dto.response.SuccessResponse;
import com.teamfresh.voc.exception.VocException;
import com.teamfresh.voc.service.VocService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voc")
@RequiredArgsConstructor
public class VocController {
	private final VocService vocService;

	/**
	 * VOC 목록 조회
	 * @return 조회된 전체 VOC 목록
	 */
	@ApiOperation(
		value = "VOC 전체 조회",
		notes = "모든 VOC의 정보를 조회한다. VOC의 정보에는 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상 정보 등이 포함된다."
	)
	@GetMapping
	public BasicResponse findAllVocList() {
		return new SuccessResponse<>(vocService.findAllVocList());
	}

	@ApiOperation(value = "VOC 등록",
		notes = "VOC의 정보를 등록한다. VOC의 정보에는 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상 정보 등이 포함된다."
	)
	@PostMapping
	public BasicResponse registryVoc(@RequestBody VocRegistryDto vocRegistryDto) {
		VocDto vocDto;
		try {
			vocDto = vocService.registryVoc(vocRegistryDto);

			if (vocDto == null) {
				return new ErrorResponse(ResponseCode.INTERNAL_ERROR, "");
			}

		} catch (VocException e) {
			return new ErrorResponse(ResponseCode.INVALID_REQUEST, e.getMessage());
		}
		return new SuccessResponse<>(vocDto);
	}
}
