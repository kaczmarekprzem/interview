package com.interview.reward.management.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionCommand(BigDecimal price, LocalDateTime date, Long customerId) {

}
