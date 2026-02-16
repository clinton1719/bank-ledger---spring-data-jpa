package com.clinton.bank_ledger.spring_data_jpa.dtos;

import com.clinton.bank_ledger.spring_data_jpa.model.Status;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponse {
  private Long accountId;
  private String accountName;
  private BigDecimal accountBalance;
  private String transactionAmount;
  private Status status;
}
