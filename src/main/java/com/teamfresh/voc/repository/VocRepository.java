package com.teamfresh.voc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamfresh.voc.domain.Voc;

@Repository
public interface VocRepository extends JpaRepository<Voc, Long> {
}
