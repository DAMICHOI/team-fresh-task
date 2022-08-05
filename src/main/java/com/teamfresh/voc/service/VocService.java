package com.teamfresh.voc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamfresh.voc.repository.VocRepository;

@Service
public class VocService {
	@Autowired
	VocRepository vocRepository;

	public List<VocDto> findAllVocList() {

		return null;
	}
}
