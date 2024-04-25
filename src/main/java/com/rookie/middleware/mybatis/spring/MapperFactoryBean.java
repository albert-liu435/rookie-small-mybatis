package com.rookie.middleware.mybatis.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Class MapperFactoryBean
 * @Description Mapper 工厂对象
 * @Author rookie
 * @Date 2024/4/25 18:02
 * @Version 1.0
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
