package com.rookie.mybatis.executor;

import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.ResultHandler;
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

    /**
     * 执行查询操作
     *
     * @param ms
     * @param parameter 查询参数
     * @param resultHandler 结果处理器
     * @param boundSql sql语句
     * @param <E>
     * @return
     */
    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}
