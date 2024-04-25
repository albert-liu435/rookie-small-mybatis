package com.rookie.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.rookie.mybatis.io.Resources;
import com.rookie.mybatis.session.SqlSession;
import com.rookie.mybatis.session.SqlSessionFactory;
import com.rookie.mybatis.session.SqlSessionFactoryBuilder;
import com.rookie.mybatis.test.dao.IActivityDao;
import com.rookie.mybatis.test.po.Activity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.Reader;

/**
 * @Class ApiTest
 * @Description 单元测试
 * @Author rookie
 * @Date 2024/4/19 16:10
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_ClassPathXmlApplicationContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IActivityDao dao = beanFactory.getBean("IActivityDao", IActivityDao.class);
        Activity res = dao.queryActivityById(new Activity(100001L));
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}
