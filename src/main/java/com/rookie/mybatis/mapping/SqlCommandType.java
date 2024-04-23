package com.rookie.mybatis.mapping;

/**
 * @Class SqlCommandType
 * @Description SQL 指令类型
 * @Author rookie
 * @Date 2024/4/23 14:34
 * @Version 1.0
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
