package com.app.app.antiquity.persistence;

import com.app.app.availability.persistence.Availability;
import com.app.app.branch.persistence.Branch;
import com.app.app.categoria.persistence.Category;
import com.app.app.city.persistence.City;
import com.app.app.company.persistence.Company;
import com.app.app.conservationStatus.persistence.ConservationStatus;
import com.app.app.period.persistence.Period;
import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "antiquity")
public class Antiquity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeAntiquity;

    @Column(nullable = false, length = 20)
    @NotNull
    String name;

    String description;

    @NotNull
    BigDecimal price;

    @NotNull
    String origin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeCategory")
    Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codePeriod")
    Period period;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeStatus")
    ConservationStatus conservationStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeAvailability")
    Availability availability;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeBranch")
    Branch branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Antiquity antiquity)) return false;
        return getCodeAntiquity().equals(antiquity.getCodeAntiquity()) && getName().equals(antiquity.getName()) && Objects.equals(getDescription(), antiquity.getDescription()) && getPrice().equals(antiquity.getPrice()) && getOrigin().equals(antiquity.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeAntiquity(), getName(), getDescription(), getPrice(), getOrigin());
    }

    @Override
    public String toString() {
        return "Antiquity{" +
                "codeBranch=" + codeAntiquity +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                '}';
    }
}
