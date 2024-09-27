package com.app.app.address.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDTO {
    String address;
    Long userId;
    Long cityId;
    Long typeAddressId;
}
