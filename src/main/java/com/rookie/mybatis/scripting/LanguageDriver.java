package com.rookie.mybatis.scripting;

import com.rookie.mybatis.executor.parameter.ParameterHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.mapping.SqlSource;
import com.rookie.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @Class LanguageDriver
 * @Description 脚本语言驱动
 * @Author rookie
 * @Date 2024/4/25 14:54
 * @Version 1.0
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建SQL源码(annotation 注解方式)
     */
    SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
