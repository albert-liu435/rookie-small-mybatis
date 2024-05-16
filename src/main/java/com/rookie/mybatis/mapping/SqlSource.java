package com.rookie.mybatis.mapping;

/**
 * @Class SqlSource
 * @Description SQL源码
 * @Author rookie
 * @Date 2024/4/25 14:49
 * @Version 1.0
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
