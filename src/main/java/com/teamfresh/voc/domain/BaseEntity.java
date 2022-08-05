package com.teamfresh.voc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@CreatedDate
	@Column(name = "created_at", columnDefinition = "TIMESTAMP COMMENT '등록일시'")
	private LocalDateTime created_at;

	@LastModifiedDate
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP COMMENT '수정일시'")
	private LocalDateTime updated_at;
}
