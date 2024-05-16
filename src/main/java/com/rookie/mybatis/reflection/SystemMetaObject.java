package com.rookie.mybatis.reflection;

import com.rookie.mybatis.reflection.factory.DefaultObjectFactory;
import com.rookie.mybatis.reflection.factory.ObjectFactory;
import com.rookie.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import com.rookie.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @Class SystemMetaObject
 * @Description 一些系统级别的元对象
 * @Author rookie
 * @Date 2024/4/25 14:11
 * @Version 1.0
 */
public class SystemMetaObject {

    //默认对象工厂
    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    //默认对象包装工厂
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

    private SystemMetaObject() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 空对象
     */
    private static class NullObject {
    }

    public static MetaObject forObject(Object object) {
        return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
    }

}
