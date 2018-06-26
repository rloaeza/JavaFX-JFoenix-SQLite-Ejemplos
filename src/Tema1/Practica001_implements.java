package Tema1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Practica001_implements extends Application  implements EventHandler<ActionEvent>{

    private Button boton1;

    public static void main(String... args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Título de primer ventana usando JavaFX");
        boton1 = new Button();
        boton1.setText("Click aquí");


        boton1.setOnAction(this);


        StackPane layout = new StackPane();
        layout.getChildren().add(boton1);

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == boton1) {
            System.out.println("Aquí realizamos alguna acción");
        }
    }
}
