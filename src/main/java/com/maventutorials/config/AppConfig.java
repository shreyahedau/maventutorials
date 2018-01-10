package com.maventutorials.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Author: Shreya Hedau : shreya.hedau
 * Date: 28-Nov-17
 */

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.maventutorials.*"})
@Import({SecurityConfig.class})
@PropertySource("classpath:/application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

    /**
     * Variable to get data from properties file
     */
    @Autowired
    private Environment env;

    /**
     * Allow property file for access
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {

        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Returning Page
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(env.getProperty("resolver.prefix"));
        viewResolver.setSuffix(env.getProperty("resolver.suffix"));
        return viewResolver;
    }

}