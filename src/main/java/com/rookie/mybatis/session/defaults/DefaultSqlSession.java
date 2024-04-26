package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.SqlSession;

/**
 * @Class DefaultSqlSession
 * @Description 默认SqlSession实现类
 * @Author rookie
 * @Date 2024/4/19 17:49
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}


