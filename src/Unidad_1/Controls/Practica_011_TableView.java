package Unidad_1.Controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Practica_011_TableView extends Application {

    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Productos> tableView;

        TableColumn<Productos, String> columnaNombre = new TableColumn<>("Nombre");
        columnaNombre.setMinWidth(200);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));



        TableColumn<Productos, String> columnaPrecio = new TableColumn<>("Precio Unitario");
        columnaPrecio.setMinWidth(200);
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Productos, String> columnaCantidad = new TableColumn<>("Existencia");
        columnaCantidad.setMinWidth(200);
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));


        tableView = new TableView<>();
        tableView.setItems(getProductos());
        tableView.getColumns().addAll(columnaNombre, columnaPrecio, columnaCantidad);


        VBox layout = new VBox();
        layout.getChildren().add(tableView);


        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ObservableList<Productos> getProductos() {
        ObservableList<Productos> productos = FXCollections.observableArrayList();

        productos.add(new Productos("HP Pavilion", 5000, 3));
        productos.add(new Productos("Sony VAIO", 15000, 3));
        productos.add(new Productos("Mac Book Pro", 30000, 1));
        return productos;
    }



    public class Productos {
        private String nombre;
        private double precio;
        private int cantidad;

        public Productos() {
            nombre = "";
            precio = 0;
            cantidad = 0;
        }
        public Productos(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
