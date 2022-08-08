package com.teamfresh.voc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 패널티 정보 Entity
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "penalty")
@DynamicUpdate
public class Penalty extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @OneToOne(mappedBy = "penalty")
	@OneToOne
	@JoinColumn(name = "voc_id")
	private Voc voc;

	@Column(name = "is_confirm", columnDefinition = "TINYINT DEFAULT 'N' COMMENT '패널티 확인 여부'", nullable = false)
	private boolean is_confirm;

	@Column(name = "is_objection", columnDefinition = "TINYINT DEFAULT 'N' COMMENT '이의제기 여부'", nullable = false)
	private boolean is_objection;
}
