package com.app.app.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class NumericValidator implements ConstraintValidator<IsItNumerical, Object> {

    @Override
    public void initialize(IsItNumerical constraintAnnotation) {
        // Método opcional para inicialización
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // No puede ser nulo
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).compareTo(BigDecimal.ZERO) > 0; // Valida BigDecimal
        } else if (value instanceof Long) {
            return (Long) value > 0; // Valida Long
        }

        return false; // Si el tipo no es BigDecimal o Long, no es válido
    }
}
