package com.company;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MyAnnotation {
    String name() default "mao";
    int age() default 18;
}
