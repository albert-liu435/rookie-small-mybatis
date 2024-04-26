package com.rookie.mybatis.session;

import com.rookie.mybatis.builder.xml.XMLConfigBuilder;
import com.rookie.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @Class SqlSessionFactoryBuilder
 * @Description 构建SqlSessionFactory的工厂
 * SqlSessionFactoryBuilder 作为整个 Mybatis 的入口，提供建造者工厂，包装 XML 解析处理，并返回对应 SqlSessionFactory 处理类。
 * 通过解析把 XML 信息注册到 Configuration 配置类中，再通过传递 Configuration 配置类到各个逻辑处理类里，包括 DefaultSqlSession 中，这样就可以在获取映射器和执行SQL的时候，从配置类中拿到对应的内容了。
 * @Author rookie
 * @Date 2024/4/23 14:35
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
