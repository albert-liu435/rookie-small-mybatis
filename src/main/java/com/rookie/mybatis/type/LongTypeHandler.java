package com.rookie.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Class LongTypeHandler
 * @Description Long类型处理器
 * @Author rookie
 * @Date 2024/4/25 15:21
 * @Version 1.0
 */
public class LongTypeHandler extends BaseTypeHandler<Long> {

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter);
    }

}
