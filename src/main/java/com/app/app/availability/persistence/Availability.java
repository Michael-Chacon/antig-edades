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
    Long id;

    @NonNull
    @Column(nullable = false, length = 20)
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability availability)) return false;
        return Objects.equals(getId(), availability.getId()) && getName().equals(availability.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "ConservationStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
