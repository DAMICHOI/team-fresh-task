package com.teamfresh.voc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.teamfresh.voc.constant.VocStatus;
import com.teamfresh.voc.constant.VocType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * VOC 정보 Entity
 */
@Entity
@Getter
@Table(name = "voc")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Voc extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", nullable = false, columnDefinition = "VARCHAR(8) COMMENT '귀책당사자'")
	@Enumerated(EnumType.STRING)
	private VocType type;

	@Column(name = "contents", nullable = false, columnDefinition = "VARCHAR(255) COMMENT '귀책 내용'")
	private String contents;

	@Column(name = "status", nullable = false, columnDefinition = "VARCHAR(10) COMMENT '진행상태'")
	@Enumerated(EnumType.STRING)
	private VocStatus status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(optional = false)
	@JoinColumn(name = "carrier_id", nullable = false)
	private Carrier carrier;

	// @OneToOne
	// @JoinColumn(name = "penalty_id")
	@OneToOne(mappedBy = "voc")
	private Penalty penalty;

	// @OneToOne
	// @JoinColumn(name = "reparation_id")
	@OneToOne(mappedBy = "voc")
	private Reparation reparation;
}
