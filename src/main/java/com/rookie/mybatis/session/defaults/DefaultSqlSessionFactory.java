package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.SqlSession;
import com.rookie.mybatis.session.SqlSessionFactory;

/**
 * @Class DefaultSqlSessionFactory
 * @Description 默认的 DefaultSqlSessionFactory
 * @Author rookie
 * @Date 2024/4/19 17:59
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
