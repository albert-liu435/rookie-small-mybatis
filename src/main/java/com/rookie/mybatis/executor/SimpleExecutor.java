package com.rookie.mybatis.executor;

import com.rookie.mybatis.executor.statement.StatementHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.ResultHandler;
import com.rookie.mybatis.transacton.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Class SimpleExecutor
 * @Description 简单执行器
 * @Author rookie
 * @Date 2024/4/24 11:46
 * @Version 1.0
 */
public class SimpleExecutor extends BaseExecutor {

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
