package Unidad_1.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Practica_010_ListView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<String>();
        ObservableList<String> elementos = FXCollections.observableArrayList();
        elementos.add("Manzana");
        elementos.add("Pera");
        elementos.add("Sandía");
        elementos.add("Melón");
        elementos.add("Aguacate");
        listView.setItems(elementos);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setOrientation(Orientation.HORIZONTAL);

        Button boton = new Button("Cuáles estan seleccionados");
        boton.setOnAction( e-> {

            ObservableList<String> elementosSeleccionados=
                    listView.getSelectionModel().getSelectedItems();

            System.out.println("\nElementos seleccionados: ");

            for(String eSelected : elementosSeleccionados) {
                System.out.println(eSelected);
            }

        });

        VBox layout = new VBox();
        layout.getChildren().add(listView);
        layout.getChildren().add(boton);
        Scene scene = new Scene(layout, 150, 50);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
