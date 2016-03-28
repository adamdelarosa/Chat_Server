package Server.DataText;

import Server.Controller;

/**
 * Created by ROSA on 3/28/16.
 */

public class DataTextConnection {

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
}
