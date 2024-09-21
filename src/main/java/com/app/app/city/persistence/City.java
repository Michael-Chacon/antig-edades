package com.app.app.city.persistence;

import com.app.app.region.persistence.Region;
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
@Entity
@Table(name = "city")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_city")
    Long codeCity;

    @Column(nullable = false, length = 20)
    @IsRequired
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeRegion")
    Region region;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City category)) return false;
        return Objects.equals(getCodeCity(), category.getCodeCity()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCity(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeCity +
                ", name='" + name + '\'' +
                '}';
    }
}
