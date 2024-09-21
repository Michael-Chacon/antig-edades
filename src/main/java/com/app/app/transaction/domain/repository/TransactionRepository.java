package com.app.app.transaction.domain.repository;

import com.app.app.transaction.persistence.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
