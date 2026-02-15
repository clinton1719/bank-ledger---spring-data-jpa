package com.clinton.bank_ledger.spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaAuditing
public class BankLedgerSpringDataJpaApplication {

  static void main(String[] args) {
    SpringApplication.run(BankLedgerSpringDataJpaApplication.class, args);
  }
}
