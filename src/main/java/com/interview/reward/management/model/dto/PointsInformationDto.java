package com.interview.reward.management.model.dto;

import java.math.BigDecimal;
import java.time.YearMonth;

public record PointsInformationDto(YearMonth yearMonth, BigDecimal bonusPoints) {

}
