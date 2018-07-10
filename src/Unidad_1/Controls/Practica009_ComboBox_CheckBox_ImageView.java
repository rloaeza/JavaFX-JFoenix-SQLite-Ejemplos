package Unidad_1.Controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica009_ComboBox_CheckBox_ImageView extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().add("Imagen World Cup");
        comboBox.getItems().add("Imagen Mascota Mundial");
        comboBox.setPromptText("Selecciona elemento");

        CheckBox checkBox = new CheckBox("Permitir cambiar imagen");

        Image imagenWC = new Image("imgs/imagen.jpg");
        Image imagenMascota = new Image("imgs/mascota.jpg");

        ImageView imageView = new ImageView();
        imageView.setImage(imagenWC);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        comboBox.setOnAction( e-> {
            if( checkBox.isSelected() ) {
                if( comboBox.getSelectionModel().getSelectedIndex()==0 ){
                    imageView.setImage(imagenWC);
                }
                else {
                    imageView.setImage(imagenMascota);
                }
            }
        });






        VBox layout = new VBox();
        layout.setPadding(new Insets(10));

        layout.getChildren().add(comboBox);
        layout.getChildren().add(checkBox);
        layout.getChildren().add(imageView);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
