package com.rookie.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Class Update
 * @Description update 语句注解
 * @Author rookie
 * @Date 2024/4/25 15:57
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Update {

    String[] value();

}
