package com.example.Asseco.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
    ElementType.TYPE
})
public @interface KoliberDescription {

    String comment() default "";

}
