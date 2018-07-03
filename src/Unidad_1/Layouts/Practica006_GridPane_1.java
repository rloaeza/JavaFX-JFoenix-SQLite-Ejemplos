package Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Practica006_GridPane_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {


        GridPane contenedor = new GridPane();
        contenedor.setVgap(10);
        contenedor.setHgap(10);
        contenedor.setPadding(new Insets(10));


        contenedor.add(new Button("0, 0"),0 , 0);
        contenedor.add(new Button("0, 1"),0 , 1);
        contenedor.add(new Button("0, 2"),0 , 2);
        contenedor.add(new Button("1, 0"),1 , 0);
        contenedor.add(new Button("1, 1"),1 , 1);
        contenedor.add(new Button("1, 2"),1 , 2);


        Scene escena = new Scene(contenedor);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
