package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * ClassName:SpringConfiguration
 * Package:config
 * Description:配置类
 *
 * @Date:2019/10/2 15:28
 * @Author:857251389@qq.com
 */
//@Configuration
@Import(JdbcConfig.class)
@ComponentScan("com.lxx")
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfiguration {


}
