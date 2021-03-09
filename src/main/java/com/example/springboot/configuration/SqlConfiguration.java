package com.example.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SqlConfiguration {
    
    @Value("${POSTGRES_USER}")
    private String user;
    @Value("${POSTGRES_PASSWORD}")
    private String password;
    @Value("${POSTGRES_DB}")
    private String db;

    @Bean
    public DataSource primary() {
      System.out.println("findme~");
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("org.postgresql.Driver");
  
      dataSource.setUrl("jdbc:postgresql://spring_dev_db:5432/" + db);
      dataSource.setUsername(user);
      dataSource.setPassword(password);

      // https://www.baeldung.com/spring-jdbc-jdbctemplate
      // https://stackoverflow.com/questions/46057625/externalising-spring-boot-properties-when-deploying-to-docker
      return dataSource;
    }
}