package com.rookie.mybatis.builder.xml;


import com.rookie.mybatis.builder.BaseBuilder;
import com.rookie.mybatis.io.Resources;
import com.rookie.mybatis.mapping.MappedStatement;
import com.rookie.mybatis.mapping.SqlCommandType;
import com.rookie.mybatis.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Class XMLConfigBuilder
 * @Description XML配置构建器，建造者模式，继承BaseBuilder
 * 用于解析 XML
 * @Author rookie
 * @Date 2024/4/23 14:33
 * @Version 1.0
 */
public class XMLConfigBuilder extends BaseBuilder {

    private Element root;

    public XMLConfigBuilder(Reader reader) {
        // 1. 调用父类初始化Configuration
        super(new Configuration());
        // 2. dom4j 处理 xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            //获取根节点
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析配置；类型别名、插件、对象工厂、对象包装工厂、设置、环境、类型转换、映射器
     *
     * @return Configuration
     */
    public Configuration parse() {
        try {
            // 解析映射器
            mapperElement(root.element("mappers"));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
        return configuration;
    }

    private void mapperElement(Element mappers) throws Exception {
        //获取mapper节点下面的资源，即*mapper.xml文件
        List<Element> mapperList = mappers.elements("mapper");
        for (Element e : mapperList) {
            //获取映射的*mapper.xml文件
            String resource = e.attributeValue("resource");
            Reader reader = Resources.getResourceAsReader(resource);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputSource(reader));
            Element root = document.getRootElement();
            //命名空间
            String namespace = root.attributeValue("namespace");

            // SELECT
            List<Element> selectNodes = root.elements("select");
            //循环SELECT节点
            for (Element node : selectNodes) {
                //节点ID
                String id = node.attributeValue("id");
                //请求参数类型
                String parameterType = node.attributeValue("parameterType");
                //返回参数类型
                String resultType = node.attributeValue("resultType");
                //sql语句
                String sql = node.getText();

                // ? 匹配
                Map<Integer, String> parameter = new HashMap<>();
                //() 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。
                //.匹配除换行符 \n 之外的任何单字符。要匹配 . ，请使用 \. 。
                //*匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
                //？匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
                //
                Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                Matcher matcher = pattern.matcher(sql);
                for (int i = 1; matcher.find(); i++) {
                    String g1 = matcher.group(1);
                    String g2 = matcher.group(2);
                    parameter.put(i, g2);
                    sql = sql.replace(g1, "?");
                }
                //资源ID 命名空间+id
                String msId = namespace + "." + id;
                String nodeName = node.getName();
                //SQL指令
                SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
                MappedStatement mappedStatement = new MappedStatement.Builder(configuration, msId, sqlCommandType, parameterType, resultType, sql, parameter).build();
                // 添加解析 SQL
                configuration.addMappedStatement(mappedStatement);
            }

            // 注册Mapper映射器
            configuration.addMapper(Resources.classForName(namespace));
        }
    }

}
