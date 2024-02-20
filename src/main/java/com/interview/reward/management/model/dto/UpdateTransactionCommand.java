package com.interview.reward.management.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateTransactionCommand(BigDecimal price, LocalDateTime date, Long customerId) {
}
