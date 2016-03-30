package Server.DataText;

import java.sql.*;
import java.util.Calendar;
/**
 * Created by ROSA on 3/28/16.
 */

public class DataTextConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/TEXTDATA";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    public void mysqlConnection(String textTransfer){
        Connection conn = null;
        Statement stmt = null;

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Time stertTime = new java.sql.Time(calendar.getTime().getTime());

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            //ADD TEXT DATA IN REAL - TIME.
            String query = " insert into TEXT_DATA_TABLE (DATE , TIME , TEXT)" + " values (?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDate (1, startDate);
            preparedStmt.setTime (2, stertTime);
            preparedStmt.setString (3, textTransfer);
            preparedStmt.execute();

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
