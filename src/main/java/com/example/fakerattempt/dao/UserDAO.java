package com.example.fakerattempt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.fakerattempt.model.User;
import com.github.javafaker.Faker;

import jakarta.servlet.annotation.WebInitParam;
import javafx.scene.chart.PieChart.Data;

@Repository
public class UserDAO {
    private static final int INITIAL_USER_COUNT = 10;

    @Autowired
    DataSource dataSource;

    ConnectionManager connectionManager;

   

    public void createDatabase(boolean deleteTables) {
        if (deleteTables)
            dropTables();

        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS STAR_TREK_USER " +
                    "(id VARCHAR(255), " +
                    " name VARCHAR(255), " +
                    " home VARCHAR(255), " +
                    " species VARCHAR(255))";

            stmt.executeUpdate(sql);

            System.out.println("Created table in given database...");
        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

    }

    private void dropTables() {

        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()) {

            String sql = "DROP TABLE IF EXISTS STAR_TREK_USER";

            stmt.executeUpdate(sql);

            System.out.println("Dropped table in given database...");
        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

    }

    public void addSampleUsers() {
        String sql = "INSERT INTO STAR_TREK_USER (id, name, home, species) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            Faker faker = new Faker();

            int i = INITIAL_USER_COUNT;
            while (i-- > 0) {
                stmt.setString(1, UUID.randomUUID().toString());

                stmt.setString(2, faker.starTrek().character());
                stmt.setString(3, faker.starTrek().location());
                stmt.setString(4, faker.starTrek().specie());
                stmt.execute();
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select id, name, home, species from star_trek_user";
        try (Connection conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
                    
                    while (rs.next()) {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setHome(rs.getString("home"));
                        user.setSpecies(rs.getString("species"));
                        users.add(user);
                    }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return users;
    }

}
