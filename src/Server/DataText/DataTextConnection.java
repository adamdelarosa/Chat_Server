package Server.DataText;

import Server.Controller;
/**
 * Created by ROSA on 3/28/16.
 */

public class DataTextConnection {

    private Controller dataSentText;

    public DataTextConnection(Controller datasenttext){
        dataSentText = datasenttext;
    }




    public void getDataText(){
        System.out.println("Message: " + dataSentText.messageStringFromServer);
    }
}
