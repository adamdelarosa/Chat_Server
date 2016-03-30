package Server.DataText;

import Server.Controller;

/**
 * Created by ROSA on 3/30/16.
 */

public class DataAddHistoryChat {

    public Controller serverChatAreaAdd;

    public DataAddHistoryChat(Controller serverchatareaadd){
        serverChatAreaAdd = serverchatareaadd;
    }

    public void printer(){
        serverChatAreaAdd.serverChatArea.appendText("BLAB");
    }

    public void getTextHistoryMysql(){
        System.out.println("Hello");
    }
}
