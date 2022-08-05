package com.teamfresh.voc.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.teamfresh.voc.domain.Penalty;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PenaltyRepositoryTest {
	@Autowired
	private PenaltyRepository penaltyRepository;

	@Test
	void create_penalty() {
		// given
		Penalty penalty = generatePenalty();

		// when
		Penalty savePenalty = penaltyRepository.save(penalty);

		// then

	}

	private Penalty generatePenalty() {
		Penalty penalty = new Penalty();
		return null;
	}
}