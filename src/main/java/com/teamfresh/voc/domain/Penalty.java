package com.teamfresh.voc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

/**
 * 패널티 정보 Entity
 */
@Entity
@Getter
@Table(name = "penalty")
public class Penalty extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "penalty")
	private Voc voc;

	@Column(name = "is_confirm", columnDefinition = "TINYINT DEFAULT 'N' COMMENT '패널티 확인 여부'", nullable = false)
	private boolean is_confirm;

	@Column(name = "is_objection", columnDefinition = "TINYINT DEFAULT 'N' COMMENT '이의제기 여부'", nullable = false)
	private boolean is_objection;
}
