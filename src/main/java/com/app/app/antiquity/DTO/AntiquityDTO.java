package com.app.app.antiquity.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AntiquityDTO {
    String name;
    String description;
    BigDecimal price;
    String origin;
    Long categoryId;
    Long periodId;
    Long conservationId;
    Long availabilityId;
    Long branchId;
    Long ownerId;

}
