package com.interview.reward.management.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class RewardManagementException extends RuntimeException {

    private final HttpStatus httpStatus;

    public RewardManagementException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
