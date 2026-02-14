package com.clinton.bank_ledger.spring_data_jpa.service;

import com.clinton.bank_ledger.spring_data_jpa.model.Account;
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

  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }
}
