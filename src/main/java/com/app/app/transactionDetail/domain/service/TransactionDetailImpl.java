package com.app.app.transactionDetail.domain.service;

import com.app.app.antiquity.domain.repository.AntiquityRepository;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.paymentMethod.domain.repository.PaymentMethodRepository;
import com.app.app.paymentMethod.persistence.PaymentMethod;
import com.app.app.transaction.domain.repository.TransactionRepository;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.transactionDetail.domain.repository.TransactionDetailRepository;
import com.app.app.transactionDetail.persistence.DTO.TransactionDetailDTO;
import com.app.app.transactionDetail.persistence.entity.TransactionDetail;
import com.app.app.user.domain.repository.UserRepository;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionDetailImpl implements ITransactionDetail {
    @Autowired
    private TransactionDetailRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AntiquityRepository antiquityRepository;
    @Autowired
    private PaymentMethodRepository paymentRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TransactionDetail> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public TransactionDetail findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TransactionDetail.class.getName(), id));
    }

    @Transactional
    @Override
    public TransactionDetail save(TransactionDetailDTO dto) {
        PaymentMethod paymentMethod = paymentRepository.findById(dto.getPaymentMethod()).orElseThrow(() -> new ResourceNotFoundException(PaymentMethod.class.getName(), dto.getPaymentMethod()));
        Antiquity antiquity = antiquityRepository.findById(dto.getAntiquity()).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), dto.getAntiquity()));
//        el propietario de la aniguedad debe ser el vendedor
        Users user = userRepository.findById(dto.getSalesman()).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), dto.getSalesman()));
        Transaction transaction = transactionRepository.findById(dto.getTransaction()).orElseThrow(() -> new ResourceNotFoundException(Transaction.class.getName(), dto.getTransaction()));

        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTransactionPrice(dto.getTransactionPrice());
        transactionDetail.setTransaction(transaction);
        transactionDetail.setAntiquity(antiquity);
        transactionDetail.setSalesman(user);
        transactionDetail.setPaymentMethod(paymentMethod);
        return repository.save(transactionDetail);
    }

    @Transactional
    @Override
    public TransactionDetail update(Long id, TransactionDetailDTO dto) {
        return repository.findById(id).map(existElement -> {
            PaymentMethod paymentMethod = paymentRepository.findById(dto.getPaymentMethod()).orElseThrow(() -> new ResourceNotFoundException(PaymentMethod.class.getName(), dto.getPaymentMethod()));
            Antiquity antiquity = antiquityRepository.findById(dto.getAntiquity()).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), dto.getAntiquity()));
//        el propietario de la aniguedad debe ser el vendedor
            Users user = userRepository.findById(dto.getSalesman()).orElseThrow(() -> new ResourceNotFoundException(Users.class.getName(), dto.getSalesman()));
            Transaction transaction = transactionRepository.findById(dto.getTransaction()).orElseThrow(() -> new ResourceNotFoundException(Transaction.class.getName(), dto.getTransaction()));

            existElement.setTransactionPrice(dto.getTransactionPrice());
            existElement.setTransaction(transaction);
            existElement.setSalesman(user);
            existElement.setAntiquity(antiquity);
            existElement.setPaymentMethod(paymentMethod);
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(TransactionDetail.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
