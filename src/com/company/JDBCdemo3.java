package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo3 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe","root","wHw121004");

            String sql = "UPDATE WPISTUDENT SET gpa = 3.1 WHERE student_id = 3";

            stmt = con.createStatement();


            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0) {
                System.out.println("Updated");
            }else{System.out.print("fucked up");}



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
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
