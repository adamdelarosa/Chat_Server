package Server.DataText;

import Server.Controller;

import java.sql.*;
import java.util.Calendar;

/**
 * Created by ROSA on 3/30/16.
 */

public class DataAddHistoryChat {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/TEXTDATA";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    public Controller serverChatAreaAdd;

    public DataAddHistoryChat(Controller serverchatareaadd){
        serverChatAreaAdd = serverchatareaadd;
    }

    public void printer(){
        serverChatAreaAdd.serverChatArea.appendText("BLAB");
    }

    public void getTextHistoryMysql(){
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            //ADD TEXT DATA IN REAL - TIME.

            //String query = " insert into TEXT_DATA_TABLE (DATE , TIME , TEXT)" + " values (?,?,?)";

            String sql = "SELECT TEXT FROM TEXT_DATA_TABLE";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String text = rs.getString("TEXT");
                System.out.println(text);
            }



            //PreparedStatement preparedStmt = conn.prepareStatement(query);
            //preparedStmt.setDate (1, startDate);
            //preparedStmt.setTime (2, stertTime);
            //preparedStmt.setString (3, null);
            //preparedStmt.execute();

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
