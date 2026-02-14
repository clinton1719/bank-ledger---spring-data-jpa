package com.clinton.bank_ledger.spring_data_jpa.controller;

import com.clinton.bank_ledger.spring_data_jpa.model.Account;
import com.clinton.bank_ledger.spring_data_jpa.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/account")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accountService;

  @GetMapping("/accounts")
  public List<Account> getAccounts() {
    log.info("Requesting accounts");
    return accountService.getAllAccounts();
  }
}
