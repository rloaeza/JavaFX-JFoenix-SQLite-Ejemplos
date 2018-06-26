package Tema1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Practica002CambiandoScenes extends Application {
    Stage window;
    Scene scene1, scene2;

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label label1 = new Label("Estamos en la primer Scene");
        Button button1 = new Button("Vamos a la Scene 2");
        button1.setOnAction(e-> window.setScene(scene2));


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,200);


        Label label2 = new Label("Estamos en la segunda Scene");
        Button button2 = new Button("Vamos a la Scene 1");
        button2.setOnAction(e-> window.setScene(scene1));


        VBox layout2 = new VBox(20);

        layout2.getChildren().add(label2);
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 400,250);


        window.setScene(scene1);
        window.show();

    }
}
