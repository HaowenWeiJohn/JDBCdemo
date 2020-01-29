package com.company;

import cn.itcast.domain.Emp;
import util.JDBCutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCdemo8_useMethodConn {
    public static void main(String[] args) {
        List<Emp> theList = new JDBCdemo8_useMethodConn().findAll();
        for(Emp theStudent : theList) System.out.println(theStudent);

        System.out.println(theList.size());
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
//                       Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe", "root", "wHw121004");

            conn = JDBCutils.getConnection();

            String sql = "SELECT * FROM WPISTUDENT";

            // create execute target
            // prepare statement
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            list = new ArrayList<Emp>();
            while (rs.next()) {
                int studnet_id = rs.getInt("student_id");
                String name = rs.getString("name");
                String major = rs.getString("major");
                double gpa = rs.getDouble("gpa");



                Emp emp = new Emp(studnet_id, name, major, gpa);
                list.add(emp);

            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JDBCutils.close(rs,stmt,conn);
        }
        return list;
    }
}
