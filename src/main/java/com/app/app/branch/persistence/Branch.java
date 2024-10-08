package com.app.app.branch.persistence;

import com.app.app.city.persistence.City;
import com.app.app.company.persistence.Company;
import com.app.app.country.persistence.Country;
import com.app.app.utils.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_branch")
    Long codeBranch;

    @Column(nullable = false, length = 100)
    @IsRequired
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeCity")
    City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeCompany")
    Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch category)) return false;
        return Objects.equals(getCodeBranch(), category.getCodeBranch()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeBranch(), getName());
    }

    @Override
    public String toString() {
        return "Antiquity{" +
                "id=" + codeBranch +
                ", name='" + name + '\'' +
                '}';
    }
}
