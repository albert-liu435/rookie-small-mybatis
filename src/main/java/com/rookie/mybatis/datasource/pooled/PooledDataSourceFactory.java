package com.rookie.mybatis.datasource.pooled;

import com.rookie.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @Class PooledDataSourceFactory
 * @Description 有连接池的数据源工厂
 * @Author rookie
 * @Date 2024/4/24 11:18
 * @Version 1.0
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
