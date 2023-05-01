package com.example.fakerattempt.dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@PropertySource({ "classpath:application.properties" })
public class ConnectionManager {

    public static Connection getConnection() throws SQLException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String JDBC_DRIVER = "org.h2.Driver.public"; // org.h2.Driver
        String DB_URL = "jdbc:h2:file:" + s + "/jeffs_db;DB_CLOSE_ON_EXIT=FALSE";
        // Database credentials
        String USER = "sa";
        String PASS = "password";
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        return dataSourceBuilder.build();
    }
}
