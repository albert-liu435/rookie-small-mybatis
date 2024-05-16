package com.rookie.mybatis.scripting.defaults;

import com.rookie.mybatis.builder.SqlSourceBuilder;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.SqlSource;
import com.rookie.mybatis.scripting.xmltags.DynamicContext;
import com.rookie.mybatis.scripting.xmltags.SqlNode;
import com.rookie.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @Class RawSqlSource
 * @Description 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @Author rookie
 * @Date 2024/4/25 14:55
 * @Version 1.0
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
