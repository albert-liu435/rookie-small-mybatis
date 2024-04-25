package com.rookie.mybatis.builder;

import com.rookie.mybatis.mapping.ResultMap;
import com.rookie.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * @Class ResultMapResolver
 * @Description 结果映射解析器
 * @Author rookie
 * @Date 2024/4/25 16:07
 * @Version 1.0
 */
public class ResultMapResolver {

    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }

}
