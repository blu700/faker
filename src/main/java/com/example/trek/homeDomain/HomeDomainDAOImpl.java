package com.example.trek.homeDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeDomainDAOImpl implements HomeDomainDAO {

    @Autowired
    DataSource dataSource;

    @Override
    @Transactional
    public void createDatabase(boolean delete) {
        if (delete) {
            dropTables();
        }

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS DOMAIN_TABLE_HOME" +
                    "(home_id VARCHAR(255) not null," +
                    "home_location VARCHAR(255))";

            stmt.executeUpdate(sql);

        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }


    @Override
    public void dropTables() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "DROP TABLE IF EXISTS DOMAIN_TABLE_HOME";

            stmt.executeUpdate(sql);

            System.out.println("Dropped table in given database...");
        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void addHomeLocations(String homes[]) {
        String sql = "INSERT INTO DOMAIN_TABLE_HOME (home_id, home_location) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            int max = 99999;
            int min = 10000;


            int i = homes.length;
            while (i-- > 0) {
                long newId = Math.round(Math.random() *(max - min + 1) + min);
                stmt.setString(1, String.valueOf(newId));
                stmt.setString(2, homes[i]);
                stmt.execute();
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    @Override
    public List<DomainTableHome> getAllLocations() {
        List<DomainTableHome> homes = new ArrayList<>();
        String sql = "select home_id, home_location from DOMAIN_TABLE_HOME";
        try (Connection conn = dataSource.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                DomainTableHome home = new DomainTableHome();
                home.setId(rs.getString("HOME_ID"));
                home.setHome(rs.getString("HOME_LOCATION"));
                homes.add(home);
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return homes;
    }
}