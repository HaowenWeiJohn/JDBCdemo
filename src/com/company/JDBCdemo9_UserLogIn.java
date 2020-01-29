package com.company;

import util.JDBCutils;

import java.sql.*;
import java.util.Scanner;

public class JDBCdemo9_UserLogIn {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your username");
        String userName = sc.nextLine();
        System.out.println("Input your password plz");
        String password = sc.nextLine();

        boolean flag = new JDBCdemo9_UserLogIn().login(userName,password);
        if(flag){
            System.out.println("correct");
        }else{
            System.out.println("cannot find this shit");
        }

    }


    // check if the user login correctly;
    public boolean login(String userName, String password) {

        if (userName == null || password == null) {
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCutils.getConnection();
            // this expression can throw a security problem!!! The sql lang will participate into the password or ....
            // we should use Prepare statement to make it work
            // use ? to make it work
            String sql = "SELECT * FROM WPIUSER WHERE name = ? AND password = ?";


            //get target
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,userName);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             JDBCutils.close(rs, pstmt, conn);
        }
        return false;
    }
}
