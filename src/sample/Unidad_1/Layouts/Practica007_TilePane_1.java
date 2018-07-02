package sample.Unidad_1.Layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Practica007_TilePane_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {


        TilePane contenedor = new TilePane();
        contenedor.setPrefColumns(3);
        contenedor.setPrefRows(2);

        contenedor.setVgap(10);
        contenedor.setHgap(10);
        contenedor.setPadding(new Insets(10));

        for(int i=0; i<6; i++){
            contenedor.getChildren().add(new Button("Boton " + i));
        }



        Scene escena = new Scene(contenedor);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
