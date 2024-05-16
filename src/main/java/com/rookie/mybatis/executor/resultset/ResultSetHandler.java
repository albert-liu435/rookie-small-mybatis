package com.rookie.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Class ResultSetHandler
 * @Description 结果集处理器
 * @Author rookie
 * @Date 2024/5/16 11:19
 * @Version 1.0
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement)throws SQLException;
}
