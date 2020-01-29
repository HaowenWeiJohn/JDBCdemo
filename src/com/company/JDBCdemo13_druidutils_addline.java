package com.company;

import util.JDBCdruidutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCdemo13_druidutils_addline {

    public static void main(String[] args){

        Connection conn = null;

        PreparedStatement pstmt = null;
        try {
            conn = JDBCdruidutils.getConnection();

            String sql = "INSERT INTO RPISTUDENT  VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);



            pstmt.setDouble(1,8);
            pstmt.setString(2,"Lisa");
            pstmt.setString(3,"CS&ME");




            int count = pstmt.executeUpdate();

            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCdruidutils.close(pstmt,conn);
        }

    }

}
