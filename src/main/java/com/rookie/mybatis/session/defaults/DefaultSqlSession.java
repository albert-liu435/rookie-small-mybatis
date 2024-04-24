package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.Environment;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class DefaultSqlSession
 * @Description 默认SqlSession实现类
 * @Author rookie
 * @Date 2024/4/19 17:49
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
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
