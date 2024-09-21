package com.app.app.transactionType.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.transactionType.domain.repository.TransactionTypeRepository;
import com.app.app.transactionType.persistence.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeImpl implements ITransactionType {
     @Autowired
    private TransactionTypeRepository repository;

    @Override
    public List<TransactionType> findAll() {
        return repository.findAll();
    }

    @Override
    public TransactionType findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TransactionType.class.getName(), id));
    }

    @Override
    public TransactionType save(TransactionType transactionType) {
        return repository.save(transactionType);
    }

    @Override
    public TransactionType update(Long id, TransactionType transactionType) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(transactionType.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(TransactionType.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
