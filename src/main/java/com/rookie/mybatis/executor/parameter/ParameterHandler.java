package com.rookie.mybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Class ParameterHandler
 * @Description 参数处理器
 * @Author rookie
 * @Date 2024/4/25 15:16
 * @Version 1.0
 */
public interface ParameterHandler {

    /**
     * 获取参数
     */
    Object getParameterObject();

    /**
     * 设置参数
     */
    void setParameters(PreparedStatement ps) throws SQLException;

}
