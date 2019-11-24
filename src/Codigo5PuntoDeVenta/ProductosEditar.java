package Codigo5PuntoDeVenta;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductosEditar implements Initializable {

    private ArrayList<Proveedor> proveedores;
    private ArrayList<Productos> productos;


    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXComboBox<String> producto;

    @FXML
    private JFXComboBox<String> proveedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    void Eliminar(ActionEvent event) throws SQLException {
        int indice = producto.getSelectionModel().getSelectedIndex();
        int idProducto = productos.get(indice).getIdProducto();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM productos WHERE idProducto="+idProducto;
        statement.execute(sql);

        producto.getSelectionModel().clearSelection();
        proveedor.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");

        productos.remove(indice);
        producto.getItems().remove(indice);
    }
    @FXML
    void Cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);

    }

    @FXML
    void Guardar(ActionEvent event) throws SQLException {
        String nombreProducto = nombre.getText();
        String descripcionProducto = descripcion.getText();
        int indiceSeleccionado = proveedor.getSelectionModel().getSelectedIndex();
        int idProveedor = proveedores.get(indiceSeleccionado).getIdProveedor();

        int indiceSeleccionadoProducto = producto.getSelectionModel().getSelectedIndex();
        int idProducto = productos.get(indiceSeleccionadoProducto).getIdProducto();

        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:pventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE productos SET " +
                "idProveedor="+idProveedor+", " +
                "nombre='"+nombreProducto+"'," +
                "descripcion='"+descripcionProducto+"' WHERE idProducto="+idProducto;
        statement.execute(sql);
        statement.close();
        connection.close();
        productos.get(indiceSeleccionadoProducto).setNombre(nombreProducto);
        productos.get(indiceSeleccionadoProducto).setDescripcion(descripcionProducto);
        productos.get(indiceSeleccionadoProducto).setIdProveedor(idProveedor);

        proveedor.getSelectionModel().clearSelection();
        producto.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:sqlite:pventa.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM productos";

            ResultSet resultSet = statement.executeQuery(sql);

            productos = new ArrayList<Productos>();

            while(resultSet.next()) {

                producto.getItems().add(resultSet.getString("nombre"));
                productos.add(new Productos(
                        resultSet.getInt("idProducto"),
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")
                ));
            }


            sql = "SELECT * FROM proveedores";

            resultSet = statement.executeQuery(sql);

            proveedores = new ArrayList<Proveedor>();

            while(resultSet.next()) {

                proveedor.getItems().add(resultSet.getString("nombre"));
                proveedores.add(new Proveedor(
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rfc"),
                        resultSet.getString("calle"),
                        resultSet.getString("colonia"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("pais"),
                        resultSet.getString("telefono"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")

                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        producto.setOnAction(e -> {
            int indice = producto.getSelectionModel().getSelectedIndex();

            nombre.setText(productos.get(indice).getNombre());
            descripcion.setText(productos.get(indice).getDescripcion());

            for(int i =0; i<proveedores.size(); i++) {
                if(productos.get(indice).getIdProveedor() == proveedores.get(i).getIdProveedor()) {
                    proveedor.getSelectionModel().select(i);
                    break;
                }
            }

        });


    }
}
