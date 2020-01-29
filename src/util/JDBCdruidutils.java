package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
    JDBC druid connection pool
 */
public class JDBCdruidutils {

    private static DataSource ds;

    static {
           try {
               Properties pro = new Properties();

               InputStream is = JDBCdruidutils.class.getClassLoader().getResourceAsStream("druid.properties");

               pro.load(is);


               ds = DruidDataSourceFactory.createDataSource(pro);

           } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
               e.printStackTrace();
           }
    }

    public static Connection getConnection() throws SQLException {

        return ds.getConnection();

    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

         if(stmt!=null) {
             try {
                 stmt.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

         if(stmt!=null) {
             try {
                 stmt.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
        }
    }

    public static void close( Statement stmt, Connection conn){
        close(null,stmt,conn);
    }


    public static DataSource getResources(){
        return ds;
    }



}
