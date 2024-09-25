package com.app.app.transaction.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BiggestBuyersDTO {
    String name;
    Long totalPurchases;
}
