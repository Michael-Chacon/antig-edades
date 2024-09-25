package com.app.app.antiquityValuation.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AntiquityMoreViewDTO {
    String antiquity;
    Long views;
}
