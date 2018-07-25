package Unidad_3_4;

import com.jfoenix.controls.JFXComboBox;
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

public class ProveedoresEditar implements Initializable {

    private int indice;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField rfc;

    @FXML
    private JFXTextField calle;

    @FXML
    private JFXTextField colonia;

    @FXML
    private JFXTextField ciudad;

    @FXML
    private JFXTextField pais;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXTextField celular;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<String> proveedor;

    private ArrayList<Proveedor> proveedores;

    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);
    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:pventa.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM proveedores WHERE idProveedor="+
                proveedores.get(indice).getIdProveedor();

        statement.execute(sql);
        
        proveedor.getItems().remove(indice);
        proveedores.remove(indice);
        nombre.setText("");
        rfc.setText("");
        calle.setText("");
        colonia.setText("");
        ciudad.setText("");
        pais.setText("");
        telefono.setText("");
        celular.setText("");
        email.setText("");



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:sqlite:pventa.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM proveedores";

            ResultSet resultSet = statement.executeQuery(sql);

            proveedores = new ArrayList<Proveedor>();
            while(resultSet.next()) {
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
                proveedor.getItems().add(
                        resultSet.getString("nombre"));
            }

            proveedor.setOnAction( e-> {
                indice = proveedor.getSelectionModel().
                        getSelectedIndex();

                nombre.setText(proveedores.get(indice).getNombre());
                rfc.setText(proveedores.get(indice).getRfc());
                calle.setText(proveedores.get(indice).getCalle());
                colonia.setText(proveedores.get(indice).getColonia());
                ciudad.setText(proveedores.get(indice).getCiudad());
                pais.setText(proveedores.get(indice).getPais());
                telefono.setText(proveedores.get(indice).getTelefono());
                celular.setText(proveedores.get(indice).getCelular());
                email.setText(proveedores.get(indice).getEmail());
            });

            statement.close();
            connection.close();






        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
