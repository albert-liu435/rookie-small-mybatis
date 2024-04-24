package com.rookie.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Class DataSourceFactory
 * @Description 数据源工厂
 * @Author rookie
 * @Date 2024/4/24 9:32
 * @Version 1.0
 */
public interface DataSourceFactory {

    /**
     * 设置属性
     *
     * @param props
     */
    void setProperties(Properties props);

    /**
     * https://blog.csdn.net/wang489687009/article/details/129706329
     * <p>
     * javax.sql.DataSource 是连接到物理数据源的工厂接口。它是 java.sql.DriverManager 功能的替代者，是获取数据库连接的首选方法。
     * DataSource 数据源在必要时可以修改它的属性。例如，如果将数据源移动到其他服务器，则可以更改 DataSource 的属性，这样访问该数据源的代码不需要做任何更改就可以获取到达到目的。
     * 有些 DataSource 的连接池实现还可以支持部分属性在程序运行期间进行修改。
     *
     * @return
     */
    DataSource getDataSource();
}
