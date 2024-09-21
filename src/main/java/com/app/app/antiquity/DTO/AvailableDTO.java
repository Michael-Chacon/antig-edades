package com.app.app.antiquity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AvailableDTO {
    Long idAntiquity;
    String name;
    BigDecimal price;
    String category;
    String conservationStatus;
}
