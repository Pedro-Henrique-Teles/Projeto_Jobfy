package com.jobfy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCPF {
    String message() default "O CPF do colaborador deve ser um CPF válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}