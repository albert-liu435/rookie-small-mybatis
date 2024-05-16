package com.rookie.mybatis.reflection.wrapper;

import com.rookie.mybatis.reflection.MetaObject;

/**
 * @Class DefaultObjectWrapperFactory
 * @Description 默认对象包装工厂
 * @Author rookie
 * @Date 2024/4/25 14:18
 * @Version 1.0
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }

}
