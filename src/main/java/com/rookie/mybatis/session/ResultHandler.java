package com.rookie.mybatis.session;

/**
 * @Class ResultHandler
 * @Description 结果处理器
 * @Author rookie
 * @Date 2024/4/24 11:44
 * @Version 1.0
 */
public interface ResultHandler {

    /**
     * 处理结果
     */
    void handleResult(ResultContext context);

}
