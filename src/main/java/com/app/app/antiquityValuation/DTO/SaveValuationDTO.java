package com.app.app.antiquityValuation.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveValuationDTO {
    Long codeAntiquity;
    Long codeUser;
    Long score;
    String comment;
}
