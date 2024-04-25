package com.rookie.mybatis.scripting.xmltags;

/**
 * @Class StaticTextSqlNode
 * @Description 静态文本SQL节点
 * @Author rookie
 * @Date 2024/4/25 14:57
 * @Version 1.0
 */
public class StaticTextSqlNode implements SqlNode{

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }

}
