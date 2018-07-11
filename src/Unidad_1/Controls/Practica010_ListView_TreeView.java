package Unidad_1.Controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.nashorn.api.tree.Tree;


public class Practica010_ListView_TreeView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ListView<String> listView = new ListView<String>();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Elemento 1");
        list.add("Elemento 2");
        listView.setItems(list);

        listView.setOrientation(Orientation.VERTICAL);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Cuales estan selecccionadas");
        button.setOnAction( e-> {
            ObservableList<String> seleccion = listView.getSelectionModel().getSelectedItems();
            for(String elemento : seleccion) {
                System.out.println(elemento);
            }
        });


        TreeItem<String> raiz, rama1, rama2;
        raiz = new TreeItem<String>("Padre");
        raiz.setExpanded(true);

        rama1 = crearHijo("Rama 1", raiz);
        rama2 = crearHijo("Rama 2", raiz);

        crearHijo("Elemento 1", rama1);
        crearHijo("Elemento 2", rama1);

        crearHijo("Elemento 1", rama2);
        crearHijo("Elemento 2", rama2);
        crearHijo("Elemento 3", rama2);
        crearHijo("Elemento 4", rama2);

        TreeView treeView = new TreeView<>(raiz);
        //treeView.setShowRoot(false);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                System.out.println(newValue);
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(listView, button, treeView);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private TreeItem<String> crearHijo(String titulo, TreeItem<String> padre) {
        TreeItem<String > hijo = new TreeItem<String>(titulo);
        hijo.setExpanded(true);
        padre.getChildren().add(hijo);
        return  hijo;
    }

}
