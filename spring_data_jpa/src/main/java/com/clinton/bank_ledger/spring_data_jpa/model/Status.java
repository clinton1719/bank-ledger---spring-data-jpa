package com.clinton.bank_ledger.spring_data_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  SUCCESS("success"),
  FAILURE("failure"),
  PENDING("pending");

  private final String status;
}
