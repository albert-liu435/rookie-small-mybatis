package com.rookie.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Class Transaction
 * @Description 事务接口
 * @Author rookie
 * @Date 2024/4/24 9:48
 * @Version 1.0
 */
public interface Transaction {

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;

    /**
     * 提交
     *
     * @throws SQLException
     */
    void commit() throws SQLException;

    /**
     * 回滚
     *
     * @throws SQLException
     */
    void rollback() throws SQLException;

    /**
     * 连接关闭
     *
     * @throws SQLException
     */
    void close() throws SQLException;
}
