package com.app.app.paymentMethod.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_method")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conde_payment_method")
    Long codePaymentMethod;

    @Column(nullable = false, length = 60)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod category)) return false;
        return Objects.equals(getCodePaymentMethod(), category.getCodePaymentMethod()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodePaymentMethod(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codePaymentMethod +
                ", name='" + name + '\'' +
                '}';
    }
}
