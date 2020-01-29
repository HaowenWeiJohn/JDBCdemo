package com.company;

import util.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class JDBCdemo10_UserEvent {
    public static void main(String[] arg) {
        Connection conn = null;

        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCutils.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "UPDATE WPISTUDENT SET gpa = gpa - ? WHERE student_id = ?";
            String sql2 = "UPDATE WPISTUDENT SET gpa = gpa + ? WHERE student_id = ?";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);


            pstmt1.setDouble(1,0.1);
            pstmt1.setInt(2,2);
            // the parameterIndex is the place of the ?

            pstmt2.setDouble(1,0.1);
            pstmt2.setInt(2,3);


            pstmt1.executeUpdate();
            // if here has an error... then fuck up
            int i = 0/0;
            pstmt2.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {

               if(conn!=null) conn.rollback();

            } catch (SQLException ex) {

                ex.printStackTrace();

            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt1,conn);
            JDBCutils.close(pstmt2,null);
        }


    }



}
