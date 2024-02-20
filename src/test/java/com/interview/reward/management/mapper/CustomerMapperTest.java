package com.interview.reward.management.mapper;

import com.interview.reward.management.model.dto.CustomerDto;
import com.interview.reward.management.model.entity.Customer;
import com.interview.reward.management.model.pojo.CustomerInternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class CustomerMapperTest {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    public void toPojo() {
        CustomerDto customerDto = new CustomerDto(1L, "John", "Doe", 100L);

        CustomerInternal customerInternal = customerMapper.toPojo(customerDto);

        Assertions.assertEquals(customerDto.id(), customerInternal.getId());
        Assertions.assertEquals(customerDto.name(), customerInternal.getName());
        Assertions.assertEquals(customerDto.surname(), customerInternal.getSurname());
        Assertions.assertEquals(customerDto.bonusPoints(), customerInternal.getBonusPoints());
    }

    @Test
    public void toEntity() {
        CustomerInternal customerInternal = new CustomerInternal(1L, "John", "Doe", 100L);

        Customer customer = customerMapper.toEntity(customerInternal);

        Assertions.assertEquals(customerInternal.getId(), customer.getId());
        Assertions.assertEquals(customerInternal.getName(), customer.getName());
        Assertions.assertEquals(customerInternal.getSurname(), customer.getSurname());
    }

    @Test
    public void toDto() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setSurname("Doe");

        CustomerDto customerDto = customerMapper.toDto(customer);

        Assertions.assertEquals(customer.getId(), customerDto.id());
        Assertions.assertEquals(customer.getName(), customerDto.name());
        Assertions.assertEquals(customer.getSurname(), customerDto.surname());
    }
}

