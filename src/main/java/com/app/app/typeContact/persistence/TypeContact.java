package com.app.app.typeContact.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_contact")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_type_contact")
    Long codeTypeContact;

    @Column(nullable = false, length = 50)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeContact category)) return false;
        return Objects.equals(getCodeTypeContact(), category.getCodeTypeContact()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeTypeContact(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeTypeContact +
                ", name='" + name + '\'' +
                '}';
    }
}
