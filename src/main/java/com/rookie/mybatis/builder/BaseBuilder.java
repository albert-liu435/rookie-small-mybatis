package com.rookie.mybatis.builder;

import com.rookie.mybatis.session.Configuration;

/**
 * @Class BaseBuilder
 * @Description 构建器的基类，建造者模式
 * @Author rookie
 * @Date 2024/4/23 14:32
 * @Version 1.0
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
