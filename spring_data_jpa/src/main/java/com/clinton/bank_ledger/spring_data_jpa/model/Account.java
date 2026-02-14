package com.clinton.bank_ledger.spring_data_jpa.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  private Long userId;

  @NotBlank
  private String accountName;

  @PositiveOrZero
  private BigDecimal accountBalance;
}
