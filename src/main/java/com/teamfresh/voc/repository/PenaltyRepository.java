package com.teamfresh.voc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamfresh.voc.domain.Penalty;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
	Penalty findByVoc_Id(Long id);
}
