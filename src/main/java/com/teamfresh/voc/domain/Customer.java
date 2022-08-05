package com.teamfresh.voc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

/**
 * 고객사 Entity
 */
@Entity
@Getter
@Table(name = "customer")
public class Customer extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name", nullable = false, columnDefinition = "VARCHAR(30) COMMENT '고객사명'")
	private String company_name;

	@Column(name = "manager_name", nullable = false, columnDefinition = "VARCHAR(5) COMMENT '담당자명'")
	private String manager_name;

	@Column(name = "contact", nullable = false, columnDefinition = "CHAR(14) COMMENT '연락처'")
	private String contact;
}
