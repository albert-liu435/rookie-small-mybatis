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

import java.io.IOException;

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
    public void test_queryActivityById() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);

        // 3. 测试验证
        Activity req = new Activity();
        req.setActivityId(100001L);
        Activity res = dao.queryActivityById(req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}
