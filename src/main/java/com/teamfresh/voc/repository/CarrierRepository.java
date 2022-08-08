package com.teamfresh.voc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamfresh.voc.domain.Carrier;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}
