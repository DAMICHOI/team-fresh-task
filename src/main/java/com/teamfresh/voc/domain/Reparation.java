package com.teamfresh.voc.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

/**
 * 배상 정보 Entity
 */
@Entity
@Getter
@Table(name = "reparation")
public class Reparation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "reparation")
	private Voc voc;

	@Column(name = "amount", nullable = false, columnDefinition = "NUMERIC(19,2) COMMENT '배상금액'")
	private BigDecimal amount;
}
