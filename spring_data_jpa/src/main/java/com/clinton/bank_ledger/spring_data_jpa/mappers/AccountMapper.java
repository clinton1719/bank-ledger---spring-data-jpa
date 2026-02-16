package com.clinton.bank_ledger.spring_data_jpa.mappers;

import com.clinton.bank_ledger.spring_data_jpa.dtos.AccountResponse;
import com.clinton.bank_ledger.spring_data_jpa.model.Account;
import com.clinton.bank_ledger.spring_data_jpa.model.Transaction;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  @Mapping(target = "transactionAmount", ignore = true)
  AccountResponse accountToAccountResponse(Account account);

  @AfterMapping
  default void enrichWithLatestTransactionAmount(
      @MappingTarget AccountResponse response, Account account) {

    Transaction latestTransaction = findMostRecentTransaction(account);

    if (latestTransaction == null) {
      response.setTransactionAmount(null);
      return;
    }

    String sign =
        Objects.equals(latestTransaction.getCreditAccount().getAccountId(), account.getAccountId())
            ? "+"
            : "-";
    String amount = latestTransaction.getTransactionAmount().toPlainString();

    response.setTransactionAmount(sign + amount);
    response.setStatus(latestTransaction.getStatus());
  }

  private Transaction findMostRecentTransaction(Account account) {
    return Stream.of(
            getLatest(account.getCreditTransactions()), getLatest(account.getDebitTransactions()))
        .filter(Objects::nonNull)
        .max(Comparator.comparing(Transaction::getTransactionDate))
        .orElse(null);
  }

  private Transaction getLatest(List<Transaction> transactions) {
    if (transactions == null || transactions.isEmpty()) {
      return null;
    }
    return Collections.max(transactions, Comparator.comparing(Transaction::getTransactionDate));
  }
}
