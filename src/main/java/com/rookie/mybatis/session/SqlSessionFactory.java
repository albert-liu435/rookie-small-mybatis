package com.rookie.mybatis.session;

/**
 * @Class SqlSessionFactory
 * @Description 工厂模式接口，构建SqlSession的工厂
 * @Author rookie
 * @Date 2024/4/19 17:59
 * @Version 1.0
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
