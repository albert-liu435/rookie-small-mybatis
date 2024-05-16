package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.mapping.Environment;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.SqlSession;
import com.rookie.mybatis.session.SqlSessionFactory;
import com.rookie.mybatis.session.TransactionIsolationLevel;
import com.rookie.mybatis.transaction.Transaction;
import com.rookie.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @Class DefaultSqlSessionFactory
 * @Description 默认的 DefaultSqlSessionFactory
 * @Author rookie
 * @Date 2024/4/19 17:59
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }


}
