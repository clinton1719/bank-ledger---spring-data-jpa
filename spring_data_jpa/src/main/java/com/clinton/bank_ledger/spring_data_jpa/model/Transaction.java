package com.clinton.bank_ledger.spring_data_jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "transactions")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transactionId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "debit_account_id", nullable = false)
  private Account debitAccount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "credit_account_id", nullable = false)
  private Account creditAccount;

  @Positive
  @Column(nullable = false)
  private BigDecimal transactionAmount;

  @CreatedDate
  @Column(nullable = false)
  private LocalDate transactionDate;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;
}
