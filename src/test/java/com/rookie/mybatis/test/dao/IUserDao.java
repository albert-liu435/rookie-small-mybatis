package com.rookie.mybatis.test.dao;


import com.rookie.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

    User queryUserInfo(User req);

}
