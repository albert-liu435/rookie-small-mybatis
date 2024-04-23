package com.rookie.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.rookie.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Class MapperRegistry
 * @Description 映射器注册机, MapperRegistry 提供包路径的扫描和映射器代理类注册机服务，完成接口对象的代理类注册处理。
 * MapperRegistry 映射器注册类的核心主要在于提供了 ClassScanner.scanPackage 扫描包路径，调用 addMapper 方法，给接口类创建 MapperProxyFactory 映射器代理类，并写入到 knownMappers 的 HashMap 缓存中。
 * @Author rookie
 * @Date 2024/4/19 17:50
 * @Version 1.0
 */
public class MapperRegistry {

    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();


    /**
     * 提供了对应的 getMapper 获取映射器代理类的方法
     *
     * @param type
     * @param sqlSession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            //实例化代理对象
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        /* Mapper 必须是接口才会注册 */
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        //进行包扫描
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }


}
