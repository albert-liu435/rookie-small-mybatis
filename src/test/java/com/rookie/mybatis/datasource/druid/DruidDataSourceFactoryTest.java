package com.rookie.mybatis.datasource.druid;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @Class DruidDataSourceFactoryTest
 * @Description
 * @Author rookie
 * @Date 2024/4/24 9:39
 * @Version 1.0
 */
public class DruidDataSourceFactoryTest {



    @Test
    public void setProperties() {
    }


//    <!--            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>-->
//<!--            <property name="url" value="jdbc:mysql://localhost:3306/db?useUnicode=true &amp; characterEncoding=gbk &amp;useSSL=false &amp; serverTimezone=Asia/Shanghai"/>-->
//<!--            <property name="username" value="root"/>-->
//<!--            <property name="password" value="root"/>-->
    @Test
    public void getDataSource() throws Exception{
        DruidDataSourceFactory druidDataSourceFactory=new DruidDataSourceFactory();
        Properties properties=new Properties();
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=gbk&useSSL=false&serverTimezone=Asia/Shanghai");
        properties.setProperty("username","root");
        properties.setProperty("password","root");

        druidDataSourceFactory.setProperties(properties);
        DataSource dataSource = druidDataSourceFactory.getDataSource();
        Connection connection = dataSource.getConnection();

        System.out.println(connection.toString());
    }
}
