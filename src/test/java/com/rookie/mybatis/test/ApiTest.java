package com.rookie.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.rookie.mybatis.binding.MapperProxyFactory;
import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.builder.xml.XMLConfigBuilder;
import com.rookie.mybatis.datasource.pooled.PooledDataSource;
import com.rookie.mybatis.io.Resources;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.session.SqlSession;
import com.rookie.mybatis.session.SqlSessionFactory;
import com.rookie.mybatis.session.SqlSessionFactoryBuilder;
import com.rookie.mybatis.session.defaults.DefaultSqlSession;
import com.rookie.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.rookie.mybatis.test.dao.IActivityDao;
import com.rookie.mybatis.test.dao.IUserDao;
import com.rookie.mybatis.test.po.Activity;
import com.rookie.mybatis.test.po.User;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Class ApiTest
 * @Description 单元测试
 * @Author rookie
 * @Date 2024/4/19 16:10
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test_queryActivityById(){
        // 1. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);
        // 2. 测试验证
        Activity res = dao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}
