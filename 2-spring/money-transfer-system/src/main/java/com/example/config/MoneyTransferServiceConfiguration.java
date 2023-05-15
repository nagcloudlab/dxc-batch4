package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.example"})
@EnableAspectJAutoProxy
public class MoneyTransferServiceConfiguration {

    @Bean("dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/accounts_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root1234");
        dataSource.setInitialSize(3);
        dataSource.setMaxActive(10);
        return dataSource;
    }

}
