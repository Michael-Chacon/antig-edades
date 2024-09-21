package com.app.app.transactionType.domain.service;

import com.app.app.transactionType.persistence.TransactionType;

import java.util.List;

public interface ITransactionType {
    List<TransactionType> findAll();
    TransactionType findById(Long id);
    TransactionType save(TransactionType transactionType);
    TransactionType update(Long id, TransactionType transactionType);
    void delete(Long id);
}
