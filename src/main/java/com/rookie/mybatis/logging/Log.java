package com.rookie.mybatis.logging;

/**
 * @Class Log
 * @Description 日志接口
 * @Author rookie
 * @Date 2024/4/25 17:53
 * @Version 1.0
 */
public interface Log {

    boolean isDebugEnabled();

    boolean isTraceEnabled();

    void error(String s, Throwable e);

    void error(String s);

    void debug(String s);

    void trace(String s);

    void warn(String s);

}
