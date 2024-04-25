package com.rookie.mybatis.scripting;

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

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
