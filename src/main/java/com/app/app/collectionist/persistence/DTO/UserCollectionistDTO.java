package com.app.app.collectionist.persistence.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCollectionistDTO {
    Long codeUser;
    Long codeBranch;
    Long codeGender;
    String name;
    String lastnameOne;
    String lastnameTwo;
    String email;
    String password;
    BigDecimal loan;
    LocalDate contractDate;

    @Override
    public String toString() {
        return "UserCollectionistMapper{" +
                "codeUser=" + codeUser +
                ", branchCode=" + codeBranch +
                ", genderCode=" + codeGender +
                ", name='" + name + '\'' +
                ", lastnameOne='" + lastnameOne + '\'' +
                ", lastnameTwo='" + lastnameTwo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + loan +
                ", contractDate=" + contractDate +
                '}';
    }
}
