package com.teamfresh.voc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfresh.voc.domain.Penalty;
import com.teamfresh.voc.domain.Voc;
import com.teamfresh.voc.dto.PenaltyDto;
import com.teamfresh.voc.dto.RequestPenaltyDto;
import com.teamfresh.voc.exception.VocException;
import com.teamfresh.voc.exception.VocExceptionMessage;
import com.teamfresh.voc.repository.PenaltyRepository;
import com.teamfresh.voc.repository.VocRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PenaltyService {
	@Autowired
	PenaltyRepository penaltyRepository;

	@Autowired
	VocRepository vocRepository;

	@Transactional
	public PenaltyDto save(RequestPenaltyDto requestPenaltyDto) {
		Voc voc = vocRepository.findById(requestPenaltyDto.getVoc_id()).orElse(null);

		if (voc == null) {
			throw new VocException(VocExceptionMessage.CHECK_NULL_VOC);
		}

		Penalty searchPenalty = penaltyRepository.findByVoc_Id(voc.getId());
		Penalty penaltyResult;

		if (searchPenalty == null) {
			penaltyResult = penaltyRepository.save(Penalty.builder()
				.voc(voc)
				.is_confirm(false)
				.is_objection(false)
				.build());
		} else {
			throw new VocException(VocExceptionMessage.CHECK_EXIST_PENALTY);
		}

		return PenaltyDto.from(penaltyResult, voc);
	}
}
