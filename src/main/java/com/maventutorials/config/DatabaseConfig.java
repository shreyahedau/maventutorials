package com.maventutorials.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.Properties;

@Configuration
@PropertySource("classpath:/databaseConfig.properties")
public class DatabaseConfig {

    /**
     * Variable to get data from properties file
     */
    @Autowired
    private Environment env;

    /**
     * Scan Packages and make table as per model files
     *
     * @return
     */
    @Bean
    public SessionFactory sessionFactory() {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.maventutorials.model").addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    /**
     * Set properties of Hibernate configuration
     *
     * @return
     */
    private Properties getHibernateProperties() {

        Properties prop = new Properties();
        prop.put("hibernate.show_sql", env.getProperty("database.hibernate.show_sql"));
        prop.put("hibernate.dialect", env.getProperty("database.hibernate.mysql.dialect"));
        prop.put("hibernate.hbm2ddl.auto", env.getProperty("database.hibernate.hbm2ddl"));
    //    prop.put("hibernate.default_schema", env.getProperty("database.hibernate.default_schema"));
        return prop;
    }

    /**
     * set Database connection using its username, password and connection URL
     *
     * @return
     */
    @Bean
    public BasicDataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("database.mysql.driver"));
        ds.setUrl(env.getProperty("database.host.url"));
        ds.setUsername(env.getProperty("database.host.username"));
        ds.setPassword(env.getProperty("database.host.password"));
        return ds;
    }

    /**
     * Enable Transaction management
     *
     * @return
     */
    @Bean
    public HibernateTransactionManager txManager() {

        return new HibernateTransactionManager(sessionFactory());
    }
}