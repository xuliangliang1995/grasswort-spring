package com.grasswort.beans.definition.model;

import java.lang.annotation.*;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

    String value() default "";
}
