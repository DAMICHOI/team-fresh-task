package com.teamfresh.voc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

/**
 * 운송기사 Entity
 */
@Entity
@Getter
@Table(name = "carrier")
public class Carrier extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "carrier_name", nullable = false, columnDefinition = "VARCHAR(5) COMMENT '운송기사명'")
	private String carrier_name;

	@Column(name = "company_name", nullable = false, columnDefinition = "VARCHAR(30) COMMENT '운송사명'")
	private String company_name;
}