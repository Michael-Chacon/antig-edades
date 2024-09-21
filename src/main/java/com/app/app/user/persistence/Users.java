package com.app.app.user.persistence;

import com.app.app.branch.persistence.Branch;
import com.app.app.country.persistence.Country;
import com.app.app.gender.persistence.Gender;
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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeUser;

    @Column(nullable = false, length = 20)
    @NotNull
    String name;

    @Column(name = "lastname_one", nullable = false, length = 15)
    @NotNull
    String lastnameOne;

    @Column(name = "lastname_two", nullable = true, length = 15)
    String lastnameTwo;

    @Column(nullable = false, length = 40)
    @NotNull
    String email;

    @Column(nullable = false, length = 255)
    @NotNull
    String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeBranch")
    Branch branch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeGender")
    Gender gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return getCodeUser().equals(users.getCodeUser()) && getName().equals(users.getName()) && getLastnameOne().equals(users.getLastnameOne()) && Objects.equals(getLastnameTwo(), users.getLastnameTwo()) && getEmail().equals(users.getEmail()) && getPassword().equals(users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeUser(), getName(), getLastnameOne(), getLastnameTwo(), getEmail(), getPassword());
    }

    @Override
    public String toString() {
        return "Collectionist{" +
                "codeUser=" + codeUser +
                ", name='" + name + '\'' +
                ", lastnameOne='" + lastnameOne + '\'' +
                ", lastnameTwo='" + lastnameTwo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
