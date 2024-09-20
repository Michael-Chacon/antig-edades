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
    @Column(name = "code_status")
    Long codeStatus;

    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConservationStatus conservationStatus)) return false;
        return Objects.equals(getCodeStatus(), conservationStatus.getCodeStatus()) && getName().equals(conservationStatus.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeStatus(), getName());
    }

    @Override
    public String toString() {
        return "ConservationStatus{" +
                "id=" + codeStatus +
                ", name='" + name + '\'' +
                '}';
    }
}
