package com.rookie.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @Class SetFieldInvoker
 * @Description setter 调用者
 * @Author rookie
 * @Date 2024/4/25 14:14
 * @Version 1.0
 */
public class SetFieldInvoker implements Invoker {

    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

}
