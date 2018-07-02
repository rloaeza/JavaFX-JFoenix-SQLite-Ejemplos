package sample.Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Practica005_BorderPane_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {
        Button bArriba = new Button("Arriba");
        Button bAbajo = new Button("Abajo");
        Button bIzquierda = new Button("Izquierda");
        Button bDerecha = new Button("Derecha");
        Button bCentro = new Button("Centro");

        BorderPane contenedor = new BorderPane();

        contenedor.setBottom(bAbajo);
        contenedor.setTop(bArriba);
        contenedor.setLeft(bIzquierda);
        contenedor.setRight(bDerecha);
        contenedor.setCenter(bCentro);

        BorderPane.setAlignment(bArriba, Pos.CENTER);



        Scene escena = new Scene(contenedor,300, 150);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
