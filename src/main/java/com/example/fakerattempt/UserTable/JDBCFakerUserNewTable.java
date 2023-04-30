package com.example.fakerattempt.UserTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFakerUserNewTable {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver.public"; //org.h2.Driver
    static final String DB_URL = "jdbc:h2:mem:org.h2.driver";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "password";

    public static void main (String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE STAR_TREK_USER " +
                    "(id VARCHAR(255), " +
                    " name VARCHAR(255), " +
                    " home VARCHAR(255), " +
                    " species VARCHAR(255))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally, block used to close resources
            try {
                if (stmt!=null)
                    conn.close();
            } catch (SQLException se) {
            } // do nothing
            try {
                if (conn!= null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    } // end main
} // end

