package com.company;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCdemo11_ConnectionPool {

    public static void main (String[] args) throws Exception {

        // create connection pool, after used the connection, we return the connection back
        // interface DataSource javax.sql: getConnection
        //C3P0 and Druid
        //if connection is from pool, Connection.close() will not close, it return the connection
        // import the fucking package
        //Druid connection pool

        //get property
//        Properties pro = new Properties();
////
////        InputStream is = JDBCdemo11_ConnectionPool.class.getClassLoader().getResourceAsStream("druid.properties");
////        pro.load(is);
////
////        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
////
////        Connection conn = ds.getConnection();
////
////        System.out.println(conn);

        Properties pro = new Properties();
        InputStream is = JDBCdemo11_ConnectionPool.class.getClassLoader().getResourceAsStream("druid.properties");

        pro.load(is);

        // get the connection poll
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
