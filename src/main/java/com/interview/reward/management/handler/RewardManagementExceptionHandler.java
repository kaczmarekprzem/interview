package com.interview.reward.management.handler;

import com.interview.reward.management.exception.CustomerException;
import com.interview.reward.management.exception.RewardManagementException;
import com.interview.reward.management.exception.TransactionException;
import com.interview.reward.management.model.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.OffsetDateTime;

@ControllerAdvice
@Slf4j
public class RewardManagementExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MessageDto> customerExceptionErrorResponse(CustomerException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new MessageDto(e.getMessage(), OffsetDateTime.now(), e.getHttpStatus()));
    }

    @ExceptionHandler(RewardManagementException.class)
    public ResponseEntity<MessageDto> rewardManagementErrorResponse(RewardManagementException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new MessageDto(e.getMessage(), OffsetDateTime.now(), e.getHttpStatus()));
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<MessageDto> transactionExceptionErrorResponse(TransactionException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new MessageDto(e.getMessage(), OffsetDateTime.now(), e.getHttpStatus()));
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageDto> generalErrorResponse(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().body(new MessageDto("Some unexpected error occurred. Please try again later.", OffsetDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
