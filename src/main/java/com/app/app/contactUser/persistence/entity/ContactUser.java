package com.app.app.contactUser.persistence.entity;

import com.app.app.typeContact.persistence.TypeContact;
import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
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
@Table(name = "contact_user")
public class ContactUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_contact_user")
    Long codeContactUser;

    @Column(nullable = false, length = 100)
    @NotNull
    String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeUser")
    Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeTypeContact")
    TypeContact typeContact;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactUser contactUser)) return false;
        return Objects.equals(getCodeContactUser(), contactUser.getCodeContactUser()) && Objects.equals(getContact(), contactUser.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeContactUser(), getContact());
    }

    @Override
    public String toString() {
        return "ContactUser{" +
                "codeAddress=" + codeContactUser +
                ", name='" + contact + '\'' +
                '}';
    }
}
