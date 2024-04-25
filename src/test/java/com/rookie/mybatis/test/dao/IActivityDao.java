package com.rookie.mybatis.test.dao;


import com.rookie.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Long activityId);


    Integer insert(Activity activity);

}
