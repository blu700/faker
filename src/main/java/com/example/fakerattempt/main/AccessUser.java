package com.example.fakerattempt.main;

import com.example.fakerattempt.dao.ConnectionManager;
import com.example.fakerattempt.dao.FakerDao;
import com.example.fakerattempt.dao.FakerDaoImpl;
import com.example.fakerattempt.model.STAR_TREK_USER;

import java.sql.*;

public class AccessUser {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver"; //org.h2.Driver
    static final String DB_URL = "jdbc:h2:mem:org.h2.driver";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "password";

//    public static void main(String[] args) {
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to a selected database...");
//            conn = ConnectionManager.getConnection();
//            System.out.println("Connected database successfully...");
//
//            //STEP 4: Execute a query
//            System.out.println("Inserting records into the table...");
//
//            FakerDao fakerDao = new FakerDaoImpl();
//
//            for (STAR_TREK_USER user : fakerDao.getAllUsers()) {
//                String sql = "INSERT INTO STAR_TREK_USER (id, name, home, species) VALUES (?, ?, ?, ?)";
//                stmt = conn.prepareStatement(sql);
//                stmt.setString(1, user.getId());
//                stmt.setString(2, user.getName());
//                stmt.setString(3, user.getHome());
//                stmt.setString(4, user.getSpecies());
//                stmt.execute();
//            }
//             System.out.println("Inserted records into the table...");
//             System.out.println("executing select");
//             ResultSet rs = conn.createStatement().executeQuery("select id, name, home, species from star_trek_user");
//             while (rs.next()) {
//                 System.out.println(rs.getString("name"));
//             }
//             rs.close();
//
//    } catch (
//    SQLException se) {
//        //Handle errors for JDBC
//        se.printStackTrace();
//    } catch (Exception e) {
//        //Handle errors for Class.forName
//        e.printStackTrace();
//    } finally {
//        //finally, block used to close resources
//        try {
//            if (stmt!=null)
//                conn.close();
//        } catch (SQLException se) {
//        } // do nothing
//        try {
//            if (conn!=null)
//                conn.close();
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } //end finally try
//    } //end try
//
//        System.out.println("Goodbye!");
//
//} //end main
} //end

