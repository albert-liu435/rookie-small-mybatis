package com.rookie.mybatis.executor.result;

import com.rookie.mybatis.session.ResultContext;

/**
 * @Class DefaultResultContext
 * @Description 默认结果上下文
 * @Author rookie
 * @Date 2024/4/25 15:37
 * @Version 1.0
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}
