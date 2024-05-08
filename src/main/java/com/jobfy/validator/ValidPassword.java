package com.jobfy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "A senha deve ter ao menos 6 caracteres e apresentar ao menos uma letra maiúscula e um caractere especial.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
