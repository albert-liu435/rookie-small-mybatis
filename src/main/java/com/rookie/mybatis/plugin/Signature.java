package com.rookie.mybatis.plugin;

/**
 * @Class Signature
 * @Description 方法签名
 * @Author rookie
 * @Date 2024/4/25 17:24
 * @Version 1.0
 */
public @interface Signature {

    /**
     * 被拦截类
     */
    Class<?> type();

    /**
     * 被拦截类的方法
     */
    String method();

    /**
     * 被拦截类的方法的参数
     */
    Class<?>[] args();

}
