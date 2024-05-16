package com.rookie.mybatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Class InterceptorChain
 * @Description 拦截器链
 * @Author rookie
 * @Date 2024/4/25 17:23
 * @Version 1.0
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors(){
        return Collections.unmodifiableList(interceptors);
    }

}
