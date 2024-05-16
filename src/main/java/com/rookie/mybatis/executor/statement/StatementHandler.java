package com.rookie.mybatis.executor.statement;

import com.rookie.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Class StatementHandler
 * @Description 语句处理器
 * @Author rookie
 * @Date 2024/4/24 11:48
 * @Version 1.0
 */
public interface StatementHandler {

    /**
     * 准备语句
     */
    Statement prepare(Connection connection) throws SQLException;

    /**
     * 参数化
     */
    void parameterize(Statement statement) throws SQLException;

    /**
     * 执行查询
     */
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

}
