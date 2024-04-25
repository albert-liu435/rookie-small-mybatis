package com.rookie.mybatis.test.plugin;

import com.rookie.mybatis.executor.statement.StatementHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.plugin.Interceptor;
import com.rookie.mybatis.plugin.Intercepts;
import com.rookie.mybatis.plugin.Invocation;
import com.rookie.mybatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Class TestPlugin
 * @Description
 * @Author rookie
 * @Date 2024/4/25 17:21
 * @Version 1.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class TestPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取StatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 获取SQL信息
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        // 输出SQL
        System.out.println("拦截SQL：" + sql);
        // 放行
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("参数输出：" + properties.getProperty("test00"));
    }

}
