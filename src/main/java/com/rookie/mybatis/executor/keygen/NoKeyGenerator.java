package com.rookie.mybatis.executor.keygen;

import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @Class NoKeyGenerator
 * @Description 不用键值生成器
 * @Author rookie
 * @Date 2024/4/25 16:17
 * @Version 1.0
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
