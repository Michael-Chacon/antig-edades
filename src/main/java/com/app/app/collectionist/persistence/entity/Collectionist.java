package com.app.app.collectionist.persistence.entity;

import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "collectionist")
public class Collectionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeCollectionist;

    @NotNull
    BigDecimal loan;

    @NotNull
    LocalDate contractDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "codeUser")
    Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collectionist collectionist)) return false;
        return Objects.equals(getCodeCollectionist(), collectionist.getCodeCollectionist()) && Objects.equals(getLoan(), collectionist.getLoan()) && Objects.equals(getContractDate(), collectionist.getContractDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCollectionist(), getLoan(), getContractDate());
    }

    @Override
    public String toString() {
        return "Collectionist{" +
                "codeUser=" + codeCollectionist +
                ", loan='" + loan + '\'' +
                ", contractDate=" + contractDate +
                '}';
    }
}
