package sample.Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Practica001_StackPane_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal)  {
        Button boton = new Button("Click aquí");
        Label etiqueta = new Label("Hola mundo");
        Rectangle rectangulo = new Rectangle(150,200, Color.AQUAMARINE);

        StackPane contenedor = new StackPane();
        contenedor.getChildren().add(boton);
        contenedor.getChildren().add(rectangulo);
        contenedor.getChildren().add(etiqueta);

        contenedor.setAlignment(boton, Pos.BOTTOM_LEFT);
        contenedor.setAlignment(rectangulo, Pos.CENTER);
        contenedor.setAlignment(etiqueta, Pos.TOP_RIGHT);



        Scene escena = new Scene(contenedor,200, 300);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
