package com.elus.repository.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.elus.repository.mapper.ERP", sqlSessionFactoryRef = "ERPSqlSessionFactory")
public class ERPDataSourceConfig {

    @Value("${slave.datasource.url}")
    private String url;

    @Value("${slave.datasource.username}")
    private String user;

    @Value("${slave.datasource.password}")
    private String password;

    @Value("${slave.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "ERPDataSource")
    public DataSource ERPDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "ERPTransactionManager")
    public DataSourceTransactionManager ERPTransactionManager() {
        return new DataSourceTransactionManager(ERPDataSource());
    }

    @Bean(name = "ERPSqlSessionFactory")
    public SqlSessionFactory ERPSqlSessionFactory(@Qualifier("ERPDataSource") DataSource erpDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(erpDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/ERP/*.xml"));
        /*从库设置sql控制台打印*/
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }
}
