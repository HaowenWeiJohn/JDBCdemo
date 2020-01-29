package com.company;

import java.awt.datatransfer.SystemFlavorMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception{
        // import jar
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/giraffe","root","wHw121004");
        //define sql

        String sql = "update WPISTUDENT set gpa = 2.8 where student_id = 1";

        Statement stmt = conn.createStatement();


        int grade = stmt.executeUpdate(sql);


        System.out.println(grade);

        stmt.close();

        conn.close();

    }
}

