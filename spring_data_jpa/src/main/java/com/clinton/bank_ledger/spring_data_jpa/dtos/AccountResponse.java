package com.clinton.bank_ledger.spring_data_jpa.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountResponse {
  private Long accountId;
  private String accountName;
  private BigDecimal accountBalance;
}
