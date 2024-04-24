package com.rookie.mybatis.builder;

import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.type.TypeAliasRegistry;

/**
 * @Class BaseBuilder
 * @Description 构建器的基类，建造者模式
 * @Author rookie
 * @Date 2024/4/23 14:32
 * @Version 1.0
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
