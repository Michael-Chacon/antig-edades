package com.app.app.address.persistence;

import com.app.app.city.persistence.City;
import com.app.app.company.persistence.Company;
import com.app.app.typeAddress.persistence.TypeAddress;
import com.app.app.user.persistence.Users;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_address")
    Long codeAddress;

    @Column(nullable = false, length = 100)
    @IsRequired
    String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeUser")
    Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeTypeAddress")
    TypeAddress typeAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeCity")
    City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getCodeAddress(), address.getCodeAddress()) && Objects.equals(getAddress(), address.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeAddress(), getAddress());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "codeAddress=" + codeAddress +
                ", name='" + address + '\'' +
                '}';
    }
}
