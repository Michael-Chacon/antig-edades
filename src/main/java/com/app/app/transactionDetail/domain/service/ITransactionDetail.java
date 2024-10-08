package com.app.app.transactionDetail.domain.service;

import com.app.app.transactionDetail.DTO.SalesHistoryDTO;
import com.app.app.transactionDetail.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;

import java.math.BigDecimal;
import java.util.List;

public interface ITransactionDetail {
    List<TransactionDetail> findAll();
    TransactionDetail findById(Long id);
    TransactionDetail savaOrUpdate(Long id, TransactionDetailDTO dto);
    void delete(Long id);
    List<SalesHistoryDTO> getHistoryToSales();

    BigDecimal getTotal();
}
