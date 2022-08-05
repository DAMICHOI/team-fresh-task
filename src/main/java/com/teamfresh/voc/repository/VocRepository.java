package com.teamfresh.voc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.teamfresh.voc.domain.Voc;

public interface VocRepository extends JpaRepository<Voc, Long> {
}
