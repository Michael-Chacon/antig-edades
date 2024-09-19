package com.app.app.conservationStatus.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conservation_status")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConservationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConservationStatus conservationStatus)) return false;
        return Objects.equals(getId(), conservationStatus.getId()) && getName().equals(conservationStatus.getName());
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
