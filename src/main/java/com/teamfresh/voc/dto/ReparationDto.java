package com.teamfresh.voc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReparationDto implements Serializable {
	private final Long id;
	private final BigDecimal amount;
}
