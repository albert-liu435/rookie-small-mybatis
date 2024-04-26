package com.rookie.mybatis.session;

/**
 * @Class SqlSessionFactory
 * @Description 工厂模式接口，构建SqlSession的工厂
 * SqlSessionFactory 是一个简单工厂模式，用于提供 SqlSession 服务，屏蔽创建细节，延迟创建过程
 * @Author rookie
 * @Date 2024/4/19 17:59
 * @Version 1.0
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     *
     * @return SqlSession
     */
    SqlSession openSession();

}
