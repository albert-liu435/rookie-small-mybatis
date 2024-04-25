package com.rookie.mybatis.executor.result;

import com.rookie.mybatis.reflection.factory.ObjectFactory;
import com.rookie.mybatis.session.ResultContext;
import com.rookie.mybatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class DefaultResultHandler
 * @Description 默认结果处理器
 * @Author rookie
 * @Date 2024/4/25 15:37
 * @Version 1.0
 */
public class DefaultResultHandler implements ResultHandler {

    private final List<Object> list;

    public DefaultResultHandler() {
        this.list = new ArrayList<>();
    }

    /**
     * 通过 ObjectFactory 反射工具类，产生特定的 List
     */
    @SuppressWarnings("unchecked")
    public DefaultResultHandler(ObjectFactory objectFactory) {
        this.list = objectFactory.create(List.class);
    }

    @Override
    public void handleResult(ResultContext context) {
        list.add(context.getResultObject());
    }

    public List<Object> getResultList() {
        return list;
    }

}

