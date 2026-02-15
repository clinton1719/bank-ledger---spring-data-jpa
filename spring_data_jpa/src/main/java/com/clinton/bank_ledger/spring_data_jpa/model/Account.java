package com.clinton.bank_ledger.spring_data_jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  @NotNull
  @Column(nullable = false)
  private Long userId;

  @NotBlank
  @Column(nullable = false)
  private String accountName;

  @PositiveOrZero
  @Column(nullable = false)
  private BigDecimal accountBalance;

  @OneToMany(mappedBy = "debitAccount", fetch = FetchType.LAZY)
  @ToString.Exclude
  private List<Transaction> debitTransactions;

  @OneToMany(mappedBy = "creditAccount", fetch = FetchType.LAZY)
  @ToString.Exclude
  private List<Transaction> creditTransactions;
}
