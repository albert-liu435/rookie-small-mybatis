package com.rookie.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Class MapperProxyFactory
 * @Description
 * @Author rookie
 * @Date 2024/4/26 10:41
 * @Version 1.0
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }


    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy=new MapperProxy<>(sqlSession,mapperInterface);

        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }

}
