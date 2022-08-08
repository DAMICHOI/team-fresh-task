package com.teamfresh.voc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfresh.voc.domain.Customer;
import com.teamfresh.voc.domain.Voc;
import com.teamfresh.voc.dto.VocDto;
import com.teamfresh.voc.dto.VocRegistryDto;
import com.teamfresh.voc.exception.VocException;
import com.teamfresh.voc.exception.VocExceptionMessage;
import com.teamfresh.voc.repository.CarrierRepository;
import com.teamfresh.voc.repository.CustomerRepository;
import com.teamfresh.voc.repository.VocRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocService {
	@Autowired
	VocRepository vocRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CarrierRepository carrierRepository;

	/**
	 * VOC 등록
	 * @param vocRegistryDto VOC 등록을 위한 DTO
	 */
	public VocDto registryVoc(VocRegistryDto vocRegistryDto) {
		carrierRepository.findById(vocRegistryDto.getCarrier_id()).orElseThrow(() ->
			new VocException(VocExceptionMessage.CHECK_CARRIER_ID));
		customerRepository.findById(vocRegistryDto.getCustomer_id()).orElseThrow(() ->
			new VocException(VocExceptionMessage.CHECK_CUSTOMER_ID));

		Long id = vocRepository.save(vocRegistryDto.toVoc()).getId();
		Voc voc = vocRepository.findById(id).orElse(null);
		return VocDto.from(voc);
	}

	/**
	 * VOC 전체 목록 조회
	 * @return VOC 전체 목록
	 */
	public List<VocDto> findAllVocList() {
		return vocRepository.findAll().stream()
			.map(VocDto::from)
			.collect(Collectors.toList());
	}
}
