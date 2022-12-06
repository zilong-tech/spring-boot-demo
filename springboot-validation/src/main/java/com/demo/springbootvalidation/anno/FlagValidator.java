package com.demo.springbootvalidation.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    // flag的有效值，多个使用,隔开
    String values();

    // flag无效时的提示内容
    String message() default "flag必须是预定义的那几个值，不能随便写";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}