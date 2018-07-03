package Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Practica003_HBox_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {
        Button boton = new Button("Click aquí");
        Label etiqueta = new Label("Hola mundo");
        Rectangle rectangulo = new Rectangle(150,200, Color.AQUAMARINE);

        HBox contenedor = new HBox(10);
        contenedor.setPadding(new Insets(20));
        contenedor.getChildren().add(boton);
        contenedor.getChildren().add(rectangulo);
        contenedor.getChildren().add(etiqueta);



        Scene escena = new Scene(contenedor);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
