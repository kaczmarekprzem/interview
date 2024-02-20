package com.interview.reward.management.model.dto;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public record MessageDto(String message, OffsetDateTime date, HttpStatus httpStatus) {
}
