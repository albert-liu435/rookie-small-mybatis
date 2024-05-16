package com.rookie.mybatis.transaction.jdbc;

import com.rookie.mybatis.session.TransactionIsolationLevel;
import com.rookie.mybatis.transaction.Transaction;
import com.rookie.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Class JdbcTransactionFactory
 * @Description JdbcTransaction 工厂
 * @Author rookie
 * @Date 2024/4/24 9:55
 * @Version 1.0
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
