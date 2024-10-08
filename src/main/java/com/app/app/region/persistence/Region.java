package com.app.app.region.persistence;

import com.app.app.country.persistence.Country;
import com.app.app.utils.IsRequired;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeRegion;

    @Column(nullable = false, length = 20)
    @IsRequired
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "codeCountry")
    Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region category)) return false;
        return Objects.equals(getCodeRegion(), category.getCodeRegion()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeRegion(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeRegion +
                ", name='" + name + '\'' +
                '}';
    }
}
