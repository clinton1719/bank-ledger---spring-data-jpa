package com.clinton.bank_ledger.spring_data_jpa.mappers;

import com.clinton.bank_ledger.spring_data_jpa.dtos.AccountResponse;
import com.clinton.bank_ledger.spring_data_jpa.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  AccountResponse toResponse(Account account);
}
