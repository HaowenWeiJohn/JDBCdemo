package com.company;

import cn.itcast.domain.Emp;
import util.JDBCutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCdemo7_toObject {

    public static void main(String[] args){
        List<Emp> theList = new JDBCdemo7_toObject().findAll();
        System.out.println(theList);
        System.out.println(theList.size());
    }
    public List<Emp> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe","root","wHw121004");

            conn = JDBCutils.getConnection();

            String sql = "SELECT * FROM WPISTUDENT";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
           list = new ArrayList<Emp>();
            while(rs.next()){
               int studnet_id =  rs.getInt("student_id");
               String name =  rs.getString("name");
               String major = rs.getString("major");
               double gpa = rs.getDouble("gpa");

               Emp emp = new Emp(studnet_id, name, major, gpa);
               list.add(emp);
            }

        } //catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
            catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(rs != null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            JDBCutils.close(rs,stmt,conn);
        }
        return list;


    }
}
