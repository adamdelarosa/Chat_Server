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
    }

}
