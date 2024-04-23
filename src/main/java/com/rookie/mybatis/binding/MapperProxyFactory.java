package com.rookie.mybatis.binding;

import com.rookie.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Class MapperProxyFactory
 * @Description 映射器代理工厂
 *
 * MapperProxyFactory 是对 MapperProxy 的包装，对外提供实例化对象的操作。当我们后面开始给每个操作数据库的接口映射器注册代理的时候，就需要使用到这个工厂类了。
 *
 * @Author rookie
 * @Date 2024/4/19 16:09
 * @Version 1.0
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<Method, MapperMethod>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface, methodCache);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
