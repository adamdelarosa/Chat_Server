package Server.DataText;

import Server.Controller;
import java.sql.*;
/**
 * Created by ROSA on 3/28/16.
 */

public class DataTextConnection {

    static final String JDBC_DRIVER_USE = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/EMP";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    private Controller dataSentText,dataRecivedText;

    public DataTextConnection(Controller datasenttext,Controller datarecivedtext){
        dataSentText = datasenttext;
        dataRecivedText = datarecivedtext;
    }

    public DataTextConnection(){
        mysqlConnection();
    }

    public void getDataTextFromServer(){
        System.out.println("Message from Server: " + dataSentText.messageStringFromServer);
    }
    public void getDataTextFromClient(){
        System.out.println("Message from Client: " + dataRecivedText.messageStringfromClient);
    }

    //Mysql connection:
    public void mysqlConnection(){
        Connection conn = null;
        Statement stmt = null;
        System.out.println("Hello");

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(USERNAME,PASSWORD,DATABASE_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
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
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
            System.out.println("Connection MYSQL CLOSED.");
        }
}
