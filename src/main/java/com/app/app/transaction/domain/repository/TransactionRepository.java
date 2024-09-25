package com.app.app.transaction.domain.repository;

import com.app.app.transaction.DTO.BiggestBuyersDTO;
import com.app.app.transaction.persistence.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT new com.app.app.transaction.DTO.BiggestBuyersDTO(CONCAT(u.name, ' ', u.lastnameOne, ' ', u.lastnameTwo), COUNT(td) AS totalPurchases) FROM TransactionDetail td " +
            "INNER JOIN td.transaction t " +
            "INNER JOIN t.users u " +
            "GROUP BY u.codeUser " +
            "ORDER BY totalPurchases DESC")
List<BiggestBuyersDTO> findTotalPurchases();
}
