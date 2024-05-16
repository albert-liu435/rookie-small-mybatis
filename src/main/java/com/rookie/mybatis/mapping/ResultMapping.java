package com.rookie.mybatis.mapping;

import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.type.JdbcType;
import com.rookie.mybatis.type.TypeHandler;

/**
 * @Class ResultMapping
 * @Description TODO
 * @Author rookie
 * @Date 2024/4/25 15:40
 * @Version 1.0
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
