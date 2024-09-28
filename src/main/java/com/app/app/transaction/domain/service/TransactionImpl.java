package com.app.app.transaction.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.transaction.DTO.BiggestBuyersDTO;
import com.app.app.transaction.domain.repository.TransactionRepository;
import com.app.app.transaction.DTO.TransactionDTO;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.transactionType.domain.repository.TransactionTypeRepository;
import com.app.app.transactionType.domain.service.ITransactionType;
import com.app.app.transactionType.persistence.TransactionType;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionImpl implements ITransaction {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private IUsers userService;

    @Autowired
    private ITransactionType transactionTypeService;

    @Transactional(readOnly = true)
    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Transaction findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Transaction.class.getName(), id));
    }

    @Override
    public Transaction saveOrUpdate(Long id, TransactionDTO transactionDTO) {
        Transaction transaction;

        if (id != null) {
            transaction = findById(id);
        } else {
            transaction = new Transaction();
        }

        Users users = userService.findById(transactionDTO.getUsers());
        TransactionType transactionType = transactionTypeService.findById(transactionDTO.getTransactionType());
        transaction.setDateTransaction(transactionDTO.getDate());
        transaction.setTransactionType(transactionType);
        transaction.setUsers(users);
        return repository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BiggestBuyersDTO> biggestBuyers() {
        return repository.findTotalPurchases();
    }
}
