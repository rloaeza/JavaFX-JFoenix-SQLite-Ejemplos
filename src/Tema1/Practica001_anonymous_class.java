package Tema1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Practica001_anonymous_class extends Application  {

    private Button boton1;

    public static void main(String... args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Título de primer ventana usando JavaFX");
        boton1 = new Button();
        boton1.setText("Click aquí");

        /*
        boton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Aquí realizamos alguna acción");
            }
        });
        */


        // Se puede usar lambda expression    e -> { }
        boton1.setOnAction(e -> System.out.println("Aquí realizamos alguna accion"));

        StackPane layout = new StackPane();
        layout.getChildren().add(boton1);

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
