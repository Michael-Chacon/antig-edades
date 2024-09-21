package com.app.app.transaction.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.transaction.domain.repository.TransactionRepository;
import com.app.app.transaction.persistence.DTO.TransactionDTO;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.transactionType.domain.repository.TransactionTypeRepository;
import com.app.app.transactionType.persistence.TransactionType;
import com.app.app.typeContact.domain.repository.TypeContactRepository;
import com.app.app.typeContact.persistence.TypeContact;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionImpl implements ITransaction {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

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

    @Transactional
    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        Users users = userRepository.findById(transactionDTO.getUsers()).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), transactionDTO.getUsers()));
        TransactionType transactionType = transactionTypeRepository.findById(transactionDTO.getTransactionType()).orElseThrow(() -> new ResourceNotFoundException(TransactionType.class.getName(), transactionDTO.getTransactionType()));

        Transaction transaction = new Transaction();
        transaction.setUsers(users);
        transaction.setTransactionType(transactionType);
        transaction.setDateTransaction(transactionDTO.getDate());
        return repository.save(transaction);
    }

    @Transactional
    @Override
    public Transaction update(Long id, TransactionDTO transactionDTO) {
        return repository.findById(id).map(existElement -> {
            Users users = userRepository.findById(transactionDTO.getUsers()).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), transactionDTO.getUsers()));
            TransactionType transactionType = transactionTypeRepository.findById(transactionDTO.getTransactionType()).orElseThrow(() -> new ResourceNotFoundException(TransactionType.class.getName(), transactionDTO.getTransactionType()));
            existElement.setDateTransaction(transactionDTO.getDate());
            existElement.setTransactionType(transactionType);
            existElement.setUsers(users);
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Transaction.class.getName(), id));
    }

    @Transactional(readOnly = true)
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
