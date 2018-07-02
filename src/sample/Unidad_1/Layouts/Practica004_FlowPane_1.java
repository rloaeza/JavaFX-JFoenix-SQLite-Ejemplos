package sample.Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Practica004_FlowPane_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {
        Button boton1 = new Button("Botón 1");
        Button boton2 = new Button("Botón 2");
        Button boton3 = new Button("Botón 3");
        Button boton4 = new Button("Botón 4");
        Button boton5 = new Button("Botón 5");

        FlowPane contenedor = new FlowPane();
        //FlowPane contenedor = new FlowPane(Orientation.VERTICAL);

        contenedor.setVgap(10);
        contenedor.setHgap(10);

        contenedor.getChildren().add(boton1);
        contenedor.getChildren().add(boton2);
        contenedor.getChildren().add(boton3);
        contenedor.getChildren().add(boton4);
        contenedor.getChildren().add(boton5);

        contenedor.setAlignment(Pos.CENTER);

        Scene escena = new Scene(contenedor,300, 150);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
