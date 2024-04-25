package com.rookie.mybatis.plugin;

import java.util.Properties;

/**
 * @Class Interceptor
 * @Description 拦截器接口
 * @Author rookie
 * @Date 2024/4/25 17:22
 * @Version 1.0
 */
public interface Interceptor {

    // 拦截，使用方实现
    Object intercept(Invocation invocation) throws Throwable;

    // 代理
    default Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 设置属性
    default void setProperties(Properties properties) {
        // NOP
    }

}
