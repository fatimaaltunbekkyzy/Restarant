package peaksoft.restarant.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//@Documented
//@Constraint(validatedBy)
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValid {
    String message() default "Возраст повара должен быть между {min} и {max} лет"; // Ката кабар

    int min() default 25; // Минималдуу жаш
    int max() default 45; // Максималдуу жаш
}

