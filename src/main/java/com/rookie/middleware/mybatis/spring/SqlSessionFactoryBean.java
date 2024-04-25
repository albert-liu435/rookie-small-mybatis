package com.rookie.middleware.mybatis.spring;


import com.rookie.mybatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Reader;

/**
 * @Class SqlSessionFactoryBean
 * @Description 会话工厂对象
 * @Author rookie
 * @Date 2024/4/25 18:03
 * @Version 1.0
 */
public class SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory>, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public SqlSessionFactory getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
