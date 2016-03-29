package Server.DataText;

import Server.Controller;
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
    static String textMessageData = "Hello again";

    private Controller dataSentText,dataRecivedText;

    public DataTextConnection(Controller datasenttext,Controller datarecivedtext){
        dataSentText = datasenttext;
        dataRecivedText = datarecivedtext;
    }

    public void getDataTextFromServer(){
        System.out.println("Message from Server: " + dataSentText.messageStringFromServer);
    }
    public void getDataTextFromClient(){
        System.out.println("Message from Client: " + dataRecivedText.messageStringfromClient);
    }

    public void mysqlConnection(){
        Connection conn = null;
        Statement stmt = null;

        // create a sql date object so we can use it in our INSERT statement
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Time stertTime = new java.sql.Time(calendar.getTime().getTime());

        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = null;

            //Create DB:
            /*sql = "CREATE DATABASE TEXTDATA";
            stmt.executeUpdate(sql);*/

            //Create Table:
            /*sql = "CREATE TABLE TEXT_DATA_TABLE " + "(DATE DATE ,TIME TIME , TEXT BLOB(1000))";
            stmt.executeUpdate(sql);*/

            //ADD TEXT DATA IN REAL - TIME.
            String query = " insert into TEXT_DATA_TABLE (DATE , TIME , TEXT)" + " values (?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDate (1, startDate);
            preparedStmt.setTime (2, stertTime);
            preparedStmt.setString (3, textMessageData);
            preparedStmt.execute();
            System.out.println(startDate);




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
        System.out.println("Goodbye!");
    }
}
