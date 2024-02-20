package com.interview.reward.management.processor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@ConfigurationProperties("reward.management.bonus.points")
@Getter
@Setter
public class BonusPointsProcessorConfiguration {

    private BigDecimal firstStage;
    private BigDecimal secondStage;
    private BigDecimal secondStageMultiplier;

}
