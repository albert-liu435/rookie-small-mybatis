package com.rookie.mybatis.session;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.datasource.druid.DruidDataSourceFactory;
import com.rookie.mybatis.datasource.pooled.PooledDataSourceFactory;
import com.rookie.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.executor.SimpleExecutor;
import com.rookie.mybatis.executor.resultset.DefaultResultSetHandler;
import com.rookie.mybatis.executor.resultset.ResultSetHandler;
import com.rookie.mybatis.executor.statement.PreparedStatementHandler;
import com.rookie.mybatis.executor.statement.StatementHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.Environment;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.transaction.Transaction;
import com.rookie.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.rookie.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Configuration
 * @Description 配置项
 * 文件解析以后会存放到 Configuration 配置类中
 * @Author rookie
 * @Date 2024/4/23 14:35
 * @Version 1.0
 */
public class Configuration {

    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);

        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

}


