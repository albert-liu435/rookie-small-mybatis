package com.rookie.mybatis.builder;

import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.ParameterMapping;
import com.rookie.mybatis.mapping.SqlSource;
import com.rookie.mybatis.session.Configuration;

import java.util.List;

/**
 * @Class StaticSqlSource
 * @Description 静态SQL源码
 * @Author rookie
 * @Date 2024/4/25 14:49
 * @Version 1.0
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
