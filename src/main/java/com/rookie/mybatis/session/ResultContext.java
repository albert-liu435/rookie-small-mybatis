package com.rookie.mybatis.session;

/**
 * @Class ResultContext
 * @Description 结果上下文
 * @Author rookie
 * @Date 2024/4/25 15:40
 * @Version 1.0
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();

}
