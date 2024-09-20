package com.app.app.period.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "period")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_period")
    Long codePeriod;

    @Column(nullable = false, length = 20)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period category)) return false;
        return Objects.equals(getCodePeriod(), category.getCodePeriod()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodePeriod(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codePeriod +
                ", name='" + name + '\'' +
                '}';
    }
}
