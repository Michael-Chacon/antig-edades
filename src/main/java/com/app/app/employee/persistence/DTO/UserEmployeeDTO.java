package com.app.app.employee.persistence.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEmployeeDTO {
    Long codeUser;
    Long codeBranch;
    Long codeGender;
    String name;
    String lastnameOne;
    String lastnameTwo;
    String email;
    String password;
    BigDecimal salary;
    LocalDate contractDate;

    @Override
    public String toString() {
        return "UserEmployeeDTO{" +
                "codeUser=" + codeUser +
                ", branchCode=" + codeBranch +
                ", genderCode=" + codeGender +
                ", name='" + name + '\'' +
                ", lastnameOne='" + lastnameOne + '\'' +
                ", lastnameTwo='" + lastnameTwo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", contractDate=" + contractDate +
                '}';
    }
}
