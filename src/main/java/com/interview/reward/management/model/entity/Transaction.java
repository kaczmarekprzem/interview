package com.interview.reward.management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    private Long bonusPoints;

    public void update(BigDecimal price, LocalDateTime date, Customer customer) {
        this.price = price;
        this.date = date;
        this.customer = customer;
    }
}
