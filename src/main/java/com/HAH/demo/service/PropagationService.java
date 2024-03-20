package com.HAH.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HAH.demo.repo.DetailsRepository;
import com.HAH.demo.repo.HeaderRepository;

@Service
public class PropagationService {

	@Autowired
	private DetailsRepository detailsRepository;
	@Autowired
	private HeaderRepository headerRepository;

	public Map<Integer, List<Integer>> save(int state, String header, String... details) {

		var headerId = headerRepository.create(header);
		if (state == 1) {
			throw new RuntimeException();
		}

		var detailsId = detailsRepository.create(headerId, details);
		if (state == 2) {
			throw new RuntimeException();
		}

		return Map.of(headerId, detailsId);
	}
}
