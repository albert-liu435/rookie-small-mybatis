package com.rookie.mybatis.executor;

import com.rookie.mybatis.executor.statement.StatementHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.ResultHandler;
import com.rookie.mybatis.session.RowBounds;
import com.rookie.mybatis.transaction.Transaction;

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
    protected int doUpdate(MappedStatement ms, Object parameter) throws SQLException {
        Statement stmt = null;
        try {
            Configuration configuration = ms.getConfiguration();
            // 新建一个 StatementHandler
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, RowBounds.DEFAULT, null, null);
            // 准备语句
            stmt = prepareStatement(handler);
            // StatementHandler.update
            return handler.update(stmt);
        } finally {
            closeStatement(stmt);
        }
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        Statement stmt = null;
        try {
            Configuration configuration = ms.getConfiguration();
            // 新建一个 StatementHandler
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, rowBounds, resultHandler, boundSql);
            // 准备语句
            stmt = prepareStatement(handler);
            // 返回结果
            return handler.query(stmt, resultHandler);
        } finally {
            closeStatement(stmt);
        }
    }

    private Statement prepareStatement(StatementHandler handler) throws SQLException {
        Statement stmt;
        Connection connection = transaction.getConnection();
        // 准备语句
        stmt = handler.prepare(connection);
        handler.parameterize(stmt);
        return stmt;
    }

}
