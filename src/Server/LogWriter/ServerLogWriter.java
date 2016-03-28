package Server.LogWriter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by ROSA on 3/28/16.
 */

public class ServerLogWriter {

    private ServerLogWriter(){
        serverLog();
    }

    Logger logger = Logger.getLogger("MyLog");
    FileHandler fileHandler;

    public void serverLog() {

        try {

            fileHandler = new FileHandler("./../server.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            logger.info("Message");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("INFO");
    }
}
