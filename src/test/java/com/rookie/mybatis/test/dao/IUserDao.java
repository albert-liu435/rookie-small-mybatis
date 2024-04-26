package com.rookie.mybatis.test.dao;

/**
 * @Class IUserDao
 * @Description TODO
 * @Author rookie
 * @Date 2024/4/26 10:48
 * @Version 1.0
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

    String queryName(String uId);
}
