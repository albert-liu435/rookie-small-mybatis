package com.rookie.mybatis.reflection.invoker;

/**
 * @Class Invoker
 * @Description 调用者
 * @Author rookie
 * @Date 2024/4/25 14:14
 * @Version 1.0
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
