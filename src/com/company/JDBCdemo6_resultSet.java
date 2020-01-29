package com.company;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCdemo6_resultSet {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs= null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe","root","wHw121004");

            String sql = "SELECT * From WPISTUDENT";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            // get result
            while(rs.next()) {

                int student_id = rs.getInt("student_id");
                String studentName = rs.getString("name");
                String studentMajor = rs.getString("major");
                double      student_gpa = rs.getDouble("gpa");

                System.out.println("StudentInfo: " + student_id + "--" + studentName + "--" + studentMajor + "--" + student_gpa);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }



        }

    }
}
