package com.rookie.mybatis.binding;

import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.session.Configuration;
import com.rookie.mybatis.mapping.SqlCommandType;
import com.rookie.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 * @Class MapperMethod
 * @Description 映射器方法
 * @Author rookie
 * @Date 2024/4/23 14:30
 * @Version 1.0
 */
public class MapperMethod {

    private final SqlCommand command;

    /**
     * @param mapperInterface 接口Class
     * @param method          接口对应的method
     * @param configuration   配置信息
     */
    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case INSERT:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }

    /**
     * SQL 指令
     */
    public static class SqlCommand {

        private final String name;
        private final SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            //映射器方法如：com.rookie.mybatis.test.dao.IUserDao.queryUserInfoById
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }

}