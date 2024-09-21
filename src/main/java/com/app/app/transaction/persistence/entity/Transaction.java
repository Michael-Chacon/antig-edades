package com.app.app.transaction.persistence.entity;

import com.app.app.transactionType.persistence.TransactionType;
import com.app.app.typeContact.persistence.TypeContact;
import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_transaction")
    Long codeTransaction;

    @Column(nullable = false, length = 100)
    @NotNull
    LocalDate dateTransaction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeUser")
    Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeTransactionType")
    TransactionType transactionType;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction transaction)) return false;
        return Objects.equals(getCodeTransaction(), transaction.getCodeTransaction()) && Objects.equals(getDateTransaction(), transaction.getDateTransaction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeTransaction(), getDateTransaction());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "codeAddress=" + codeTransaction +
                ", name='" + dateTransaction + '\'' +
                '}';
    }
}
