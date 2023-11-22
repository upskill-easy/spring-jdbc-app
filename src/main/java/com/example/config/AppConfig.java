package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = { "com.example" })
@PropertySource("classpath:application.properties")
public class AppConfig {

    private final Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(env.getProperty("app.db.username"));
        dataSource.setPassword(env.getProperty("app.db.password"));
        dataSource.setDriverClassName(env.getProperty("app.db.driverClassName"));
        dataSource.setUrl(env.getProperty("app.db.url"));
        return dataSource;
    }
    
    // @Bean
    // public DriverManagerDataSource dataSource(){
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //     dataSource.setUsername("root");
    //     dataSource.setPassword("password");
    //     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    //     dataSource.setUrl("jdbc:mysql://localhost:3306/city");
    //     return dataSource;
    // }
    
    /**
     * XML configuration
     * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
     *  <property name="userName" value="root" />
     *  <property name="password" value="password" />
     *  <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
     *  <property name="url" value="jdbc:mysql://localhost:3306/city" />
     * </bean>
     */
}
