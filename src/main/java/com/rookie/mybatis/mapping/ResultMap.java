package com.rookie.mybatis.mapping;

import com.rookie.mybatis.session.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @Class ResultMap
 * @Description 结果映射
 * @Author rookie
 * @Date 2024/4/25 15:40
 * @Version 1.0
 */
public class ResultMap {

    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;
    private Set<String> mappedColumns;

    private ResultMap() {
    }

    public static class Builder {
        private ResultMap resultMap = new ResultMap();

        public Builder(Configuration configuration, String id, Class<?> type, List<ResultMapping> resultMappings) {
            resultMap.id = id;
            resultMap.type = type;
            resultMap.resultMappings = resultMappings;
        }

        public ResultMap build() {
            resultMap.mappedColumns = new HashSet<>();
            // step-13 新增加，添加 mappedColumns 字段
            for (ResultMapping resultMapping : resultMap.resultMappings) {
                final String column = resultMapping.getColumn();
                if (column != null) {
                    resultMap.mappedColumns.add(column.toUpperCase(Locale.ENGLISH));
                }
            }
            return resultMap;
        }

    }

    public String getId() {
        return id;
    }

    public Set<String> getMappedColumns() {
        return mappedColumns;
    }

    public Class<?> getType() {
        return type;
    }

    public List<ResultMapping> getResultMappings() {
        return resultMappings;
    }

    public List<ResultMapping> getPropertyResultMappings() {
        return resultMappings;
    }

}
