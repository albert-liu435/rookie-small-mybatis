package com.rookie.mybatis.scripting.xmltags;

import com.rookie.mybatis.executor.parameter.ParameterHandler;
import com.rookie.mybatis.mapping.BoundSql;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.mapping.SqlSource;
import com.rookie.mybatis.scripting.LanguageDriver;
import com.rookie.mybatis.scripting.defaults.DefaultParameterHandler;
import com.rookie.mybatis.scripting.defaults.RawSqlSource;
import com.rookie.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @Class XMLLanguageDriver
 * @Description XML语言驱动器
 * @Author rookie
 * @Date 2024/4/25 14:57
 * @Version 1.0
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    /**
     * step-12 新增方法，用于处理注解配置 SQL 语句
     */
    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        // 暂时不解析动态 SQL
        return new RawSqlSource(configuration, script, parameterType);
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}
