package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "insert into WPISTUDENT values (4,'Lisa', 'CS', 3.5)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe", "root","wHw121004");
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count > 0){
                System.out.println("UPDATED");
            }else {System.out.println("fail to add this shit");}



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            // cannot release a null value
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (conn != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                }

            }
        }

    }

