package com.app.app.paymentMethod.domain.repository;

import com.app.app.paymentMethod.persistence.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
