package Codigo5PuntoDeVenta;

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

public class PuntoDeVenta extends Application {

    @FXML
    private Pane contenedor;

    @FXML
    void acercaDe(ActionEvent event) {

    }

    @FXML
    void editarCliente(ActionEvent event) {

        cargarFormulario("ClientesEditar.fxml");
    }

    @FXML
    void editarExistencia(ActionEvent event) {
        cargarFormulario("ExistenciaEditar.fxml");
    }

    @FXML
    void editarProducto(ActionEvent event) {
        cargarFormulario("ProductosEditar.fxml");
    }

    @FXML
    void editarProveedor(ActionEvent event) {
        cargarFormulario("ProveedoresEditar.fxml");
    }



    @FXML
    void nuevaExistencia(ActionEvent event) {
        cargarFormulario("ExistenciaNuevo.fxml");
    }

    @FXML
    void nuevaVenta(ActionEvent event) {
        cargarFormulario("VentaNueva.fxml");
    }

    @FXML
    void nuevoCliente(ActionEvent event)  {
        cargarFormulario("ClientesNuevo.fxml");
    }

    @FXML
    void nuevoProducto(ActionEvent event)  {
        cargarFormulario("ProductosNuevo.fxml");
    }

    @FXML
    void nuevoProveedor(ActionEvent event)  {
        cargarFormulario("ProveedoresNuevo.fxml");
    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }

    private void cargarFormulario(String formulario) {

        try {
            contenedor.getChildren().clear();
            Parent layout = FXMLLoader.load(getClass().
                    getResource(formulario));
            contenedor.getChildren().add(layout);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().
                getResource("PuntoDeVenta.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Punto de Venta 0.0.1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
