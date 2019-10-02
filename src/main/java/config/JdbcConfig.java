package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * ClassName:JdbcConfig
 * Package:config
 * Description:
 *
 * @Date:2019/10/2 19:53
 * @Author:857251389@qq.com
 */
public class JdbcConfig {
    @Value("${jdbc.Driver}")
    private String driver;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.User}")
    private String user;
    @Value("${jdbc.Password}")
    private String password;

    /**
     * 创建QueryRunner对象
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源
     * @return
     */
    @Bean(name = "datasource")
    public DataSource createDatesource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
