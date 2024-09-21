package com.app.app.transactionType.domain.repository;

import com.app.app.transactionType.persistence.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
