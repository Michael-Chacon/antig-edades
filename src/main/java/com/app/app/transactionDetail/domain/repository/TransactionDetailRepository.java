package com.app.app.transactionDetail.domain.repository;

import com.app.app.transactionDetail.DTO.SalesHistoryDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
    @Query("SELECT new com.app.app.transactionDetail.DTO.SalesHistoryDTO(" +
            "CONCAT(seller.name, ' ', seller.lastnameOne), " + // Nombre del vendedor
            "CONCAT(buyer.name, ' ', buyer.lastnameOne), " + // Nombre del comprador
            "antiquity.name, " + // Nombre de la antigüedad
            "td.transactionPrice, " + // Precio de la transacción
            "transaction.dateTransaction) " + // Fecha de la transacción
            "FROM TransactionDetail td " +
            "INNER JOIN td.salesman seller " + // Vendedor
            "INNER JOIN td.transaction transaction " + // Transacción
            "INNER JOIN transaction.users buyer " + // Comprador
            "INNER JOIN td.antiquity antiquity " + // Antigüedad
            "WHERE seller.codeUser = 7") // Filtrar por el ID del vendedor
    List<SalesHistoryDTO> findSalesHistory();

//    @Query("SELECT new com.app.app.transactionDetail.DTO.SalesHistoryDTO(CONCAT(sm.name, ' ', sm.lastnameOne), CONCAT(b.name, ' ', b.lastnameOne), a.name, td.transactionPrice, t.dateTransaction) FROM TransactionDetail td " +
//            "INNER JOIN td.salesman sm " +
//            "INNER JOIN td.antiquity a " +
//            "INNER JOIN td.transaction t " +
//            "INNER JOIN td.t.users b " +
//            "WHERE sm.codeUser = 7")
//    List<SalesHistoryDTO> findSalesHistory();
}
