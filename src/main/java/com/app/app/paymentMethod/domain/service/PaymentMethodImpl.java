package com.app.app.paymentMethod.domain.service;

import com.app.app.exceptions.ResourceNotFoundException;
import com.app.app.paymentMethod.domain.repository.PaymentMethodRepository;
import com.app.app.paymentMethod.persistence.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentMethodImpl implements IPaymentMethod {
     @Autowired
    private PaymentMethodRepository repository;

     @Transactional(readOnly = true)
    @Override
    public List<PaymentMethod> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PaymentMethod findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PaymentMethod.class.getName(), id));
    }

    @Transactional
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    @Transactional
    @Override
    public PaymentMethod update(Long id, PaymentMethod paymentMethod) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(paymentMethod.getName());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(PaymentMethod.class.getName(), id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
