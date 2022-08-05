package com.teamfresh.voc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfresh.voc.domain.Penalty;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
}
