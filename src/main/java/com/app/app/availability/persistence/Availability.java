package com.app.app.availability.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "availability")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_availability")
    Long codeAvailability;

    @NonNull
    @Column(nullable = false, length = 20)
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability availability)) return false;
        return Objects.equals(getCodeAvailability(), availability.getCodeAvailability()) && getName().equals(availability.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeAvailability(), getName());
    }

    @Override
    public String toString() {
        return "ConservationStatus{" +
                "id=" + codeAvailability +
                ", name='" + name + '\'' +
                '}';
    }
}
