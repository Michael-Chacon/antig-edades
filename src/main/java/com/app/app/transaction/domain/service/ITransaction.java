package com.app.app.transaction.domain.service;

import com.app.app.transaction.persistence.DTO.TransactionDTO;
import com.app.app.transaction.persistence.entity.Transaction;

import java.util.List;

public interface ITransaction {
    List<Transaction> findAll();
    Transaction findById(Long id);
    Transaction save(TransactionDTO dto);
    Transaction update(Long id, TransactionDTO dto);
    void delete(Long id);
}
