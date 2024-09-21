package com.app.app.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NumericValidator.class) // El validador que usará esta anotación
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Aplica a campos y parámetros
@Retention(RetentionPolicy.RUNTIME)
public @interface IsItNumerical {

    String message() default " field cannot be empty and must be greater than zero"; // Mensaje predeterminado
    Class<?>[] groups() default {}; // Parámetros requeridos por Bean Validation
    Class<? extends Payload>[] payload() default {}; // Parámetros requeridos por Bean Validation
}
