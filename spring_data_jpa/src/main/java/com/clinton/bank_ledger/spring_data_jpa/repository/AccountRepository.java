package com.clinton.bank_ledger.spring_data_jpa.repository;

import com.clinton.bank_ledger.spring_data_jpa.model.Account;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<@NonNull Account, @NonNull Long> {}
