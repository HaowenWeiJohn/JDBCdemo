package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo4 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe", "root","wHw121004");

            String sql = "Delete FROM WPISTUDENT WHERE student_id = 4";

            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

            if(count != 0){System.out.println("Deleted this shit");
            } else {System.out.println("nothing happened");}


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
