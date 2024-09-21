package com.app.app.country.persistence;

import com.app.app.utils.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conde_country")
    Long codeCountry;

    @Column(nullable = false, length = 20)
    @IsRequired
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country category)) return false;
        return Objects.equals(getCodeCountry(), category.getCodeCountry()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCountry(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeCountry +
                ", name='" + name + '\'' +
                '}';
    }
}
