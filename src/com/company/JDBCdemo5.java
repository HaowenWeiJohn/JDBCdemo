package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo5 {
    public static void main(String[] arg) {
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe", "root", "wHw121004");

            String sql = "CREATE TABLE RPISTUDENT (student_id INT, name VARCHAR(20), Major VARCHAR(20), PRIMARY KEY (student_id))";

            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
