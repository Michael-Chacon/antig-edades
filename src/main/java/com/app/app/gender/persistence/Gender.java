package com.app.app.gender.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gender")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeGender;

    @Column(nullable = false, length = 20)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender category)) return false;
        return Objects.equals(getCodeGender(), category.getCodeGender()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeGender(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getCodeGender() +
                ", name='" + name + '\'' +
                '}';
    }
}
