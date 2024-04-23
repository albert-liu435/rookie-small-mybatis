package com.rookie.mybatis.session;

import com.rookie.mybatis.binding.MapperRegistry;
import com.rookie.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Configuration
 * @Description 配置项
 * 文件解析以后会存放到 Configuration 配置类中
 * @Author rookie
 * @Date 2024/4/23 14:35
 * @Version 1.0
 */
public class Configuration {

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

}
