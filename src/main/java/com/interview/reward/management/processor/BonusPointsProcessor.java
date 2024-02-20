package com.interview.reward.management.processor;

import com.interview.reward.management.model.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BonusPointsProcessor {

    private final BonusPointsProcessorConfiguration bonusPointsProcessorConfiguration;

    public Long calculate(Transaction transaction) {
        BigDecimal transactionValueStage1 = bonusPointsProcessorConfiguration.getFirstStage();
        BigDecimal transactionValueStage2 = bonusPointsProcessorConfiguration.getSecondStage();
        BigDecimal stage2Multiplier = bonusPointsProcessorConfiguration.getSecondStageMultiplier();
        BigDecimal price = transaction.getPrice();
        if (transaction.getPrice() == null || transaction.getPrice().compareTo(transactionValueStage1) < 0) {
            return 0L;
        }
        BigDecimal bonusPoints = BigDecimal.ZERO;

        if (price.compareTo(transactionValueStage1) >= 0 && price.compareTo(transactionValueStage2) < 0) {
            bonusPoints = bonusPoints.add(transactionValueStage1).subtract(transactionValueStage2).add(price);
        }

        if (price.compareTo(transactionValueStage2) >= 0) {
            bonusPoints = bonusPoints.add(price.subtract(transactionValueStage2).multiply(stage2Multiplier))
                    .add(transactionValueStage2.subtract(transactionValueStage1));
        }
        return bonusPoints.longValue();
    }
}
