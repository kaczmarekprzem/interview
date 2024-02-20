package com.interview.reward.management.controller;

import com.interview.reward.management.mapper.CustomerMapper;
import com.interview.reward.management.model.dto.CustomerDto;
import com.interview.reward.management.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create customer", tags = "Customer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerMapper.toPojo(customerDto));
    }

    @GetMapping("/{customerId}")
    @Operation(summary = "Get information about customer", tags = "Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CustomerDto.class))}),
            @ApiResponse(responseCode = "404", description = "NOT FOUND",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class))})
    })
    public CustomerDto getCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{transactionId}")
    @Operation(summary = "Update customer", tags = "Customer")
    public CustomerDto updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerMapper.toPojo(customerDto));
    }

    @DeleteMapping("/{transactionId}")
    @Operation(summary = "Delete customer", tags = "Customer")
    public CustomerDto deleteTransaction(@PathVariable("customerId") Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

}
