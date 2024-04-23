package com.rookie.mybatis.binding;

import com.rookie.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Class MapperProxyFactory
 * @Description 映射器代理工厂
 * @Author rookie
 * @Date 2024/4/19 16:09
 * @Version 1.0
 */
public class MapperProxyFactory<T> {

    //被代理的接口Class
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 创建代理对象
     *
     * @param sqlSession
     * @return
     */
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        //返回代理对象
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
