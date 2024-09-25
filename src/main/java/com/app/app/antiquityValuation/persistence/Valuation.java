package com.app.app.antiquityValuation.persistence;

import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.user.persistence.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "valuation")
public class Valuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codeValuation;

    @Column(nullable = false, length = 100)
    @NotNull
    Long valuation;

    @Column(nullable  = true)
    String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeUser")
    Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeAntiquity")
    Antiquity antiquity;

}
