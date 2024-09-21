package com.app.app.paymentMethod.domain.service;

import com.app.app.paymentMethod.persistence.PaymentMethod;

import java.util.List;

public interface IPaymentMethod {
    List<PaymentMethod> findAll();
    PaymentMethod findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    PaymentMethod update(Long id, PaymentMethod paymentMethod);
    void delete(Long id);
}
