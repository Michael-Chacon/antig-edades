package com.app.app.transactionDetail.persistence.entity;

import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.paymentMethod.persistence.PaymentMethod;
import com.app.app.transaction.persistence.entity.Transaction;
import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeTransactionDetail;

    @Column(nullable = false, length = 100)
    @NotNull
    BigDecimal transactionPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeUser")
    Users salesman;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codePaymentMethod")
    PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeAntiquity")
    Antiquity antiquity;

    @ManyToOne
    @JoinColumn(name = "codeTransaction")
    Transaction transaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionDetail that)) return false;
        return Objects.equals(getCodeTransactionDetail(), that.getCodeTransactionDetail()) && Objects.equals(getTransactionPrice(), that.getTransactionPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeTransactionDetail(), getTransactionPrice());
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "codeTransacionDetail=" + codeTransactionDetail +
                ", transactionPrice=" + transactionPrice +
                '}';
    }
}
