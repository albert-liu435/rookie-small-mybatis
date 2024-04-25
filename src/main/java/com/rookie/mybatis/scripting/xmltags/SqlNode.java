package com.rookie.mybatis.scripting.xmltags;

/**
 * @Class SqlNode
 * @Description SQL 节点
 * @Author rookie
 * @Date 2024/4/25 14:57
 * @Version 1.0
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}
