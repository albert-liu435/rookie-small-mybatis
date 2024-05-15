package com.rookie.mybatis.mapping;

import com.rookie.mybatis.session.Configuration;

import java.util.Map;

/**
 * @Class MappedStatement
 * @Description 映射语句类
 * 采用建造者模式
 * @Author rookie
 * @Date 2024/4/23 14:34
 * @Version 1.0
 */
public class MappedStatement {

    private Configuration configuration;
    //xml sql语句ID,如：com.rookie.mybatis.test.dao.IUserDao.queryUserInfoById
    private String id;
    //SQL指令
    private SqlCommandType sqlCommandType;
    private BoundSql boundSql;

    MappedStatement() {
        // constructor disabled
    }

    /**
     * 建造者
     */
    public static class Builder {

        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.boundSql = boundSql;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getId() {
        return id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public BoundSql getBoundSql() {
        return boundSql;
    }
}
