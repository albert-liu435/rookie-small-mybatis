package com.rookie.mybatis.reflection.wrapper;

import com.rookie.mybatis.reflection.MetaObject;

/**
 * @Class ObjectWrapperFactory
 * @Description 对象包装工厂
 * @Author rookie
 * @Date 2024/4/25 14:19
 * @Version 1.0
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
