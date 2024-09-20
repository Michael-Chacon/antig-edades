package com.app.app.company.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_company")
    Long codeCompany;

    @Column(nullable = false, length = 40)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(getCodeCompany(), company.getCodeCompany()) && getName().equals(company.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCompany(), getName());
    }

    @Override
    public String toString() {
        return "company{" +
                "id=" + codeCompany +
                ", name='" + name + '\'' +
                '}';
    }
}
