package com.app.app.transactionDetail.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesHistoryDTO {
    String salesman;
    String buyer;
    String antiquity;
    BigDecimal price;
    LocalDate date;
}
