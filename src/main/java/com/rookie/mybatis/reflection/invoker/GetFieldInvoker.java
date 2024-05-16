package com.rookie.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @Class GetFieldInvoker
 * @Description getter 调用者
 * @Author rookie
 * @Date 2024/4/25 14:13
 * @Version 1.0
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

}
