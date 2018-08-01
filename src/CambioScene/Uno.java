package CambioScene;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Uno extends Application {


    static Stage stage;

    @FXML
    void Cambiar(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("Dos.fxml"));
        Scene scene = new Scene(layout);


        stage.setScene(scene);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("Uno.fxml"));
        stage = primaryStage;
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
