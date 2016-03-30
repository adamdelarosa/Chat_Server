package Server.DataText;

import Server.Controller;
import java.sql.*;
import java.util.Calendar;
/**
 * Created by ROSA on 3/28/16.
 */

public class DataAddMysqlTable {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/TEXTDATA";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public void mysqlConnectionAddTable(){
        Connection conn = null;
        Statement stmt = null;

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Time stertTime = new java.sql.Time(calendar.getTime().getTime());

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = null;

            //Create DB:
            /*sql = "CREATE DATABASE TEXTDATA";
            stmt.executeUpdate(sql);*/

            //Create Table:
            /*sql = "CREATE TABLE TEXT_DATA_TABLE " + "(DATE DATE ,TIME TIME , TEXT BLOB(1000))";
            stmt.executeUpdate(sql);*/

            System.out.println("Database.");

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
