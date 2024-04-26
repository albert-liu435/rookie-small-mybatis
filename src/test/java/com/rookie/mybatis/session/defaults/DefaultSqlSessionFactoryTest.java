package com.rookie.mybatis.session.defaults;

import com.rookie.mybatis.binding.MapperProxyFactoryTest;
import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.session.SqlSession;
import com.rookie.mybatis.session.SqlSessionFactory;
import com.rookie.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @Class DefaultSqlSessionFactoryTest
 * @Description TODO
 * @Author rookie
 * @Date 2024/4/26 13:43
 * @Version 1.0
 */
public class DefaultSqlSessionFactoryTest {

    private Logger logger = LoggerFactory.getLogger(DefaultSqlSessionFactoryTest.class);


//    @Test
//    public void test_MapperProxyFactory() {
//        // 1. 注册 Mapper
//        MapperRegistry registry = new MapperRegistry();
//        registry.addMappers("com.rookie.mybatis.test.dao");
//
//        // 2. 从 SqlSession 工厂获取 Session
//        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        // 3. 获取映射器对象
//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//
//        // 4. 测试验证
//        String res = userDao.queryUserName("10001");
//        logger.info("测试结果：{}", res);
//    }


}
