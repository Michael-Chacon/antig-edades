package com.app.app.typeAddress.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_address")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_type_address")
    Long codeTypeAddress;

    @Column(nullable = false, length = 50)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeAddress category)) return false;
        return Objects.equals(getCodeTypeAddress(), category.getCodeTypeAddress()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeTypeAddress(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeTypeAddress +
                ", name='" + name + '\'' +
                '}';
    }
}
