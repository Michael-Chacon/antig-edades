package com.app.app.transactionDetail.persistence.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionDetailDTO {
    Long codeTransacionDetail;
    BigDecimal transactionPrice;
    Long salesman;
    Long paymentMethod;
    Long antiquity;
    Long transaction;
}
