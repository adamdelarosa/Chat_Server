package Server;

import Server.HealthCheck.ConnectionStatus;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Controller controller = new Controller();



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Frame/sample.fxml"));
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 1200, 620));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void stop(){
        controller.closeConnection();
        controller.connectionStatusStop();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
