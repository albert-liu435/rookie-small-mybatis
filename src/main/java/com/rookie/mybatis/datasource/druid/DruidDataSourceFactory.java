package com.rookie.mybatis.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.rookie.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Class DruidDataSourceFactory
 * @Description Druid 数据源工厂
 * @Author rookie
 * @Date 2024/4/24 9:36
 * @Version 1.0
 */
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;


    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));

        return dataSource;
    }
}
