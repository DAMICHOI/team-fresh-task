package com.teamfresh.voc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * @return
	 */
	@ApiOperation(
		value = "VOC 전체 조회",
		notes = "모든 VOC의 정보를 조회한다.\nVOC의 정보에는 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상 정보 등이 포함된다."
	)
	@GetMapping
	public List<VocDto> findAllVocList() {
		List<VocDto> vocDtoList = vocService.findAllVocList();
		return vocDtoList;
	}

	@ApiOperation(value = "VOC 등록",
		notes = "VOC의 정보를 등록한다.\nVOC의 정보에는 귀책 당사자, 귀책 내용, 패널티 내용, 기사 확인 여부, 이의제기 여부, 배상 정보 등이 포함된다."
	)
	@PostMapping
	public ResponseEntity registryVoc(@RequestBody VocDto vocDto) {
		// vocService.

		return ResponseEntity.ok().build();
	}
}
