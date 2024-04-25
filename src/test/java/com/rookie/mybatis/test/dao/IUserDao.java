package com.rookie.mybatis.test.dao;



public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

    String queryName(String uId);

}

