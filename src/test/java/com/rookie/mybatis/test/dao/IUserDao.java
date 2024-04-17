package com.rookie.mybatis.test.dao;

import com.rookie.mybatis.test.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("SELECT id, userId, userName, userHead\n" +
            "        FROM user\n" +
            "        where id = #{id}")
    User queryUserInfo(User req);

    @Select("SELECT id, userId, userName, userHead\n" +
            "FROM user")
    List<User> queryUserInfoList();

}
