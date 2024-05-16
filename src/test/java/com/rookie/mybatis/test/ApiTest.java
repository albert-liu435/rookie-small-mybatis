package com.rookie.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.rookie.mybatis.binding.MapperProxyFactory;
import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.builder.xml.XMLConfigBuilder;
import com.rookie.mybatis.datasource.pooled.PooledDataSource;
import com.rookie.mybatis.executor.Executor;
import com.rookie.mybatis.io.Resources;
import com.rookie.mybatis.mapping.Environment;
import com.rookie.mybatis.session.*;
import com.rookie.mybatis.session.defaults.DefaultSqlSession;
import com.rookie.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.rookie.mybatis.test.dao.IActivityDao;
import com.rookie.mybatis.test.dao.IUserDao;
import com.rookie.mybatis.test.po.Activity;
import com.rookie.mybatis.test.po.User;
import com.rookie.mybatis.transaction.Transaction;
import com.rookie.mybatis.transaction.TransactionFactory;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
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

    @Test
    public void test_ognl() throws OgnlException {
        Activity req = new Activity();
        req.setActivityId(1L);
        req.setActivityName("测试活动");
        req.setActivityDesc("小傅哥的测试内容");

        OgnlContext context = new OgnlContext();
        context.setRoot(req);
        Object root = context.getRoot();

        Object activityName = Ognl.getValue("activityName", context, root);
        Object activityDesc = Ognl.getValue("activityDesc", context, root);
        Object value = Ognl.getValue("activityDesc.length()", context, root);

        System.out.println(activityName + "\t" + activityDesc + " length：" + value);
    }


}
