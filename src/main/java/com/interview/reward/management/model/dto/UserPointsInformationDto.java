package com.interview.reward.management.model.dto;

import java.util.List;

public record UserPointsInformationDto(Long userId, List<PointsInformationDto> pointsInformation,
                                       Long totalBonusPoints) {

}
