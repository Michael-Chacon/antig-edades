package com.app.app.transactionDetail.domain.repository;

import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
}
