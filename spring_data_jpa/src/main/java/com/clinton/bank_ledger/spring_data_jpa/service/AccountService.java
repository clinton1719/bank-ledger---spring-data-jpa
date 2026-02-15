package com.clinton.bank_ledger.spring_data_jpa.service;

import com.clinton.bank_ledger.spring_data_jpa.dtos.AccountResponse;
import com.clinton.bank_ledger.spring_data_jpa.mappers.AccountMapper;
import com.clinton.bank_ledger.spring_data_jpa.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;

  public List<AccountResponse> getAllAccounts() {
    List<AccountResponse> accountResponses =
        accountRepository.findAll().stream()
            .peek(account -> System.out.println(account.toString()))
            .map(accountMapper::toResponse)
            .toList();
    log.info("Fetched {} accounts", accountResponses.size());
    return accountResponses;
  }
}
