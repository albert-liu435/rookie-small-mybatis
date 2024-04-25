package com.rookie.mybatis.executor;

import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.ResultHandler;
import com.rookie.mybatis.session.RowBounds;
import com.rookie.mybatis.transacton.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @Class Executor
 * @Description 执行器
 * @Author rookie
 * @Date 2024/4/24 11:43
 * @Version 1.0
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}
