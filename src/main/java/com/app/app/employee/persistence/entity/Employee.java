package com.app.app.employee.persistence.entity;

import com.app.app.user.persistence.Users;
import com.app.app.utils.IsItNumerical;
import com.app.app.utils.IsRequired;
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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeEmployee;

    @IsItNumerical
    BigDecimal salary;

    LocalDate contractDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "codeUser")
    Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getCodeEmployee(), employee.getCodeEmployee()) && Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getContractDate(), employee.getContractDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeEmployee(), getSalary(), getContractDate());
    }

    @Override
    public String toString() {
        return "Collectionist{" +
                "codeUser=" + codeEmployee +
                ", salary='" + salary + '\'' +
                ", contractDate=" + contractDate +
                '}';
    }
}
