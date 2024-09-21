package com.app.app.contactUser.persistence.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactUserDTO {
    String contact;
    Long users;
    Long typeContact;
}
