package Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Practica002_VBox_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {
        Button boton = new Button("Click aquí");
        Label etiqueta = new Label("Hola mundo");
        Rectangle rectangulo = new Rectangle(150,200, Color.AQUAMARINE);

        VBox contenedor = new VBox(10);
        contenedor.setPadding(new Insets(10));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(boton);
        contenedor.getChildren().add(rectangulo);
        contenedor.getChildren().add(etiqueta);



        Scene escena = new Scene(contenedor);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
