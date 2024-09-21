package com.app.app.transactionDetail.domain.service;

import com.app.app.transactionDetail.persistence.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;

import java.util.List;

public interface ITransactionDetail {
    List<TransactionDetail> findAll();
    TransactionDetail findById(Long id);
    TransactionDetail save(TransactionDetailDTO dto);
    TransactionDetail update(Long id, TransactionDetailDTO dto);
    void delete(Long id);
}
