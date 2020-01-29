package com.company;

import util.JDBCdruidutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo12_druidutils {

    public static void main(String[] args){

        new JDBCdemo12_druidutils().UpdateTheStudentGPA(3,2.5);

    }


    public void UpdateTheStudentGPA(int student_id, double currentgpa){

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // get connection

            conn = JDBCdruidutils.getConnection();


            conn.setAutoCommit(false);

            String sql = "UPDATE WPISTUDENT SET gpa=? WHERE student_id=?";


            pstmt = conn.prepareStatement(sql);


            pstmt.setDouble(1,currentgpa);
            pstmt.setInt(2,student_id);
            // execute

            int count = pstmt.executeUpdate();

            //conn.commit();
            if(count!=0){
                System.out.println("update successful");
            }else System.out.println("fail");

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        }finally {
            JDBCdruidutils.close(pstmt,conn);
        }

    }
}
