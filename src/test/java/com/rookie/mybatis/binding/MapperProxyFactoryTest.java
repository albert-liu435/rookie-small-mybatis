package com.rookie.mybatis.binding;

import com.rookie.mybatis.test.ApiTest;
import com.rookie.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class MapperProxyFactoryTest
 * @Description TODO
 * @Author rookie
 * @Date 2024/4/26 10:45
 * @Version 1.0
 */
public class MapperProxyFactoryTest {

    private Logger logger = LoggerFactory.getLogger(MapperProxyFactoryTest.class);


    @Test
    public void test_MapperProxyFactory() throws Exception {
        MapperProxyFactory<IUserDao> factory=new MapperProxyFactory<>(IUserDao.class);

        Map<String,String> sqlSession=new HashMap<>();
        sqlSession.put("com.rookie.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.rookie.mybatis.test.dao.IUserDao.queryUserAge","模拟执行Mapper.xml文件中的SQL");

        IUserDao userDao = factory.newInstance(sqlSession);

        String s = userDao.queryUserName("10001");
        logger.info("测试结果：{}",s);


    }

}
