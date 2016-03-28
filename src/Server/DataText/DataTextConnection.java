package Server.DataText;

import Server.Controller;
import java.sql.*;
/**
 * Created by ROSA on 3/28/16.
 */

public class DataTextConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/EMP";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

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
        try{
            //JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            //Query:
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data:
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //Close up:
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //JDBC Error:
            se.printStackTrace();
        }catch(Exception e){
            //Class.forName Error:
            e.printStackTrace();
        }finally{
            //Close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
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
