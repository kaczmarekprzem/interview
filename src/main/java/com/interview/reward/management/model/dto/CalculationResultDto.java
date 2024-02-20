package com.interview.reward.management.model.dto;

import java.time.LocalDate;
import java.util.List;

public record CalculationResultDto(LocalDate startDate, LocalDate endDate,
                                   List<UserPointsInformationDto> userPointsInformation) {

}
