package com.rookie.mybatis.test.dao;

import com.rookie.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Activity activity);

    Integer insert(Activity activity);

}
