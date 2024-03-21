package com.HAH.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HAH.demo.repo.DetailsRepository;
import com.HAH.demo.repo.HeaderRepository;

@Service
public class PropagationService {

	@Autowired
	private DetailsRepository detailsRepository;
	@Autowired
	private HeaderRepository headerRepository;

	public Result save(int state, String header, String... details) {

		var headerId = headerRepository.create(header);
		if (state == 1) {
			throw new RuntimeException();
		}

		var detailsId = detailsRepository.create(headerId, details);
		if (state == 2) {
			throw new RuntimeException();
		}

		return new Result(headerId, detailsId);
	}
}
