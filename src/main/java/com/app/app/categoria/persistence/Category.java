package com.app.app.categoria.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_category")
    Long codeCategory;

    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getCodeCategory(), category.getCodeCategory()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCategory(), getName());
    }

    @Override
    public String toString() {
        return "ConservationStatus{" +
                "id=" + codeCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
