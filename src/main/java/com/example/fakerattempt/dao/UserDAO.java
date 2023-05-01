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

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.fakerattempt.model.STAR_TREK_USER;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO implements UserInterface<STAR_TREK_USER> {
    private static final int INITIAL_USER_COUNT = 10;


    @Autowired
    DataSource dataSource;

    @Override
    @Transactional
    public void createDatabase(boolean deleteTables) {
        if (deleteTables)
            dropTables();

        try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS STAR_TREK_USER " +
                    "(user_id VARCHAR(255) not null, " +
                    " user_home VARCHAR(255), " +
                    " user_name VARCHAR(255)," +
                    " user_species VARCHAR(255))";

            stmt.executeUpdate(sql);

            System.out.println("Created table in given database...");
        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

    }

    @Override
    public void dropTables() {

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

    @Override
    @Transactional
    public void addSampleUsers() {
        String sql = "INSERT INTO STAR_TREK_USER (user_id, user_home, user_name, user_species) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            Faker faker = new Faker();

            int i = INITIAL_USER_COUNT;
            while (i-- > 0) {
                stmt.setString(1, UUID.randomUUID().toString());
                stmt.setString(2, faker.starTrek().location());
                stmt.setString(3, faker.starTrek().character());
                stmt.setString(4, faker.starTrek().specie());
                stmt.execute();
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    @Override
    public List<STAR_TREK_USER> getAllUsers() {
        List<STAR_TREK_USER> users = new ArrayList<>();
        String sql = "select user_id, user_home, user_name, user_species from star_trek_user";
        try (Connection conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
                    
                    while (rs.next()) {
                        STAR_TREK_USER user = new STAR_TREK_USER();
                        user.setId(rs.getString("USER_ID"));
                        user.setName(rs.getString("USER_HOME"));
                        user.setHome(rs.getString("USER_NAME"));
                        user.setSpecies(rs.getString("USER_SPECIES"));
                        users.add(user);
                    }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return users;
    }

}
