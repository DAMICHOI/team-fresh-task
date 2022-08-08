package com.teamfresh.voc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamfresh.voc.domain.Reparation;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Long> {
}
