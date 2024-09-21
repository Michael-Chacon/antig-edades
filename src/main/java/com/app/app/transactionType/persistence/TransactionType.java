package com.app.app.transactionType.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction_type")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_transaction_type")
    Long codeTransactionType;

    @Column(nullable = false, length = 50)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionType category)) return false;
        return Objects.equals(getCodeTransactionType(), category.getCodeTransactionType()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeTransactionType(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeTransactionType +
                ", name='" + name + '\'' +
                '}';
    }
}
