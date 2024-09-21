package com.app.app.transactionDetail.domain.repository;

import com.app.app.transactionDetail.DTO.SalesHistoryDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
    @Query("SELECT new com.app.app.transactionDetail.DTO.SalesHistoryDTO(CONCAT(sm.name, ' ', sm.lastnameOne), CONCAT(b.name, ' ', b.lastnameOne), a.name, td.transactionPrice, t.dateTransaction) FROM TransactionDetail td " +
            "INNER JOIN td.salesman sm " +
            "INNER JOIN td.antiquity a " +
            "INNER JOIN td.transaction t " +
            "INNER JOIN t.users b " +
            "WHERE sm.codeUser = 7")
    List<SalesHistoryDTO> findSalesHistory();
}
