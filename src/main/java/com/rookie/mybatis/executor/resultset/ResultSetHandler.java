package com.rookie.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Class ResultSetHandler
 * @Description 结果集处理器
 * @Author rookie
 * @Date 2024/4/24 11:51
 * @Version 1.0
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}
