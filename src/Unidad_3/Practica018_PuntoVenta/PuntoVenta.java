package Unidad_3.Practica018_PuntoVenta;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PuntoVenta extends Application {
    Stage stage;


    @FXML
    private Pane contenedor;

    @FXML
    void menuAcercaDe(ActionEvent event) {

    }

    @FXML
    void menuClientes(ActionEvent event) {

    }

    @FXML
    void menuExistencia(ActionEvent event) {

    }

    @FXML
    void menuNuevaVenta(ActionEvent event) {

    }

    @FXML
    void menuProductos(ActionEvent event) {

    }

    @FXML
    void menuEditarProveedores(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("ProveedoresEditar.fxml"));
        contenedor.getChildren().add(layout);
    }

    @FXML
    void menuNuevoProveedores(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("ProveedoresNuevo.fxml"));
        contenedor.getChildren().add(layout);
    }

    @FXML
    void menuSalir(ActionEvent event) {
        Platform.exit();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent layout = FXMLLoader.load(getClass().getResource("PuntoVenta.fxml"));
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
