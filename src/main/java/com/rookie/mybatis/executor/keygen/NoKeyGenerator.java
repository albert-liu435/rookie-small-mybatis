package com.rookie.mybatis.executor.keygen;

import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @Class NoKeyGenerator
 * @Description 不用键值生成器
 * @Author rookie
 * @Date 2024/5/16 11:58
 * @Version 1.0
 */
public class NoKeyGenerator implements KeyGenerator{
    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {

    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {

    }
}
