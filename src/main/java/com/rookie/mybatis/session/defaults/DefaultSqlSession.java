package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.session.SqlSession;

/**
 * @Class DefaultSqlSession
 * @Description 默认SqlSession实现类
 * @Author rookie
 * @Date 2024/4/19 17:49
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

}

