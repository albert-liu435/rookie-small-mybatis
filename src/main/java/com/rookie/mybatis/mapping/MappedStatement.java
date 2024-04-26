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

    private String parameterType;
    private String resultType;
    //SQL语句
    private String sql;
    private Map<Integer, String> parameter;

    MappedStatement() {
        // constructor disabled
    }

    /**
     * 建造者
     */
    public static class Builder {

        private MappedStatement mappedStatement = new MappedStatement();

        /**
         * @param configuration
         * @param id             sql指令的唯一ID
         * @param sqlCommandType SQL指令
         * @param parameterType  请求参数类型
         * @param resultType     返回参数类型
         * @param sql            sql语句
         * @param parameter      请求参数
         */
        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, String parameterType, String resultType, String sql, Map<Integer, String> parameter) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.parameterType = parameterType;
            mappedStatement.resultType = resultType;
            mappedStatement.sql = sql;
            mappedStatement.parameter = parameter;
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

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Integer, String> parameter) {
        this.parameter = parameter;
    }

}
