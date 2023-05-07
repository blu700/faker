package com.example.trek.user;

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

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO implements UserInterface {
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
                        user.setHome(rs.getString("USER_HOME"));
                        user.setName(rs.getString("USER_NAME"));
                        user.setSpecies(rs.getString("USER_SPECIES"));
                        users.add(user);
                    }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return users;
    }

    @Override
    public void addNewUser(STAR_TREK_USER stu) {
        String sql = "INSERT INTO STAR_TREK_USER (user_id, user_home, user_name, user_species) VALUES (?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, UUID.randomUUID().toString());
            stmt.setString(2, stu.home);
            stmt.setString(3, stu.name);
            stmt.setString(4, stu.species);
            stmt.execute();


        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public Object getUser(String userId) {

        STAR_TREK_USER user = new STAR_TREK_USER();
        String sql = "select * from STAR_TREK_USER " +
                "where user_id='" + userId + "'";

        try (Connection conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                user.setId(rs.getString("USER_ID"));
                user.setHome(rs.getString("USER_HOME"));
                user.setName(rs.getString("USER_NAME"));
                user.setSpecies(rs.getString("USER_SPECIES"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(STAR_TREK_USER stu) {
        String sql = "UPDATE STAR_TREK_USER " +
                    "SET USER_HOME = ?, " +
                        "USER_NAME = ?, " +
                        "USER_SPECIES = ? " +
                    "WHERE USER_ID = '" + stu.id + "'";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, stu.home);
            stmt.setString(2, stu.name);
            stmt.setString(3, stu.species);
            stmt.execute();


        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}
