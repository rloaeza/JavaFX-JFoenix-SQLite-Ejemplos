package Unidad_3.Practica018_PuntoVenta;

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

    ArrayList<Proveedor> proveedores;
    int index;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXComboBox<String> nombre;

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
    void Cancelar(ActionEvent event) {
        Pane p = (Pane) contenedor.getParent();
        p.getChildren().remove(0);
    }

    @FXML
    void Eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(50);

        String sql = "DELETE FROM proveedores WHERE idProveedor="+proveedores.get(index).getId();

        statement.execute(sql);
        statement.close();
        connection.close();
        rfc.setText("");
        calle.setText("");
        colonia.setText("");
        ciudad.setText("");
        pais.setText("");
        telefono.setText("");
        celular.setText("");
        email.setText("");
        cargarCombo();
    }

    @FXML
    void Guardar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoventa.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(50);

        String sql = "UPDATE proveedores SET " +
                "rfc='"+rfc.getText()+"', " +
                "calle='"+calle.getText()+"', " +
                "colonia='"+colonia.getText()+"', " +
                "ciudad='"+ciudad.getText()+"', " +
                "pais='"+pais.getText()+"', " +
                "telefono='"+telefono.getText()+"', " +
                "celular='"+celular.getText()+"', " +
                "email='"+email.getText()+"' " +

                "WHERE idProveedor="+proveedores.get(index).getId();

        statement.execute(sql);
        statement.close();
        connection.close();

        rfc.setText("");
        calle.setText("");
        colonia.setText("");
        ciudad.setText("");
        pais.setText("");
        telefono.setText("");
        celular.setText("");
        email.setText("");
        cargarCombo();
    }

    private void cargarCombo() {
        try {
            nombre.getItems().clear();
            nombre.getSelectionModel().clearSelection();
            proveedores.clear();

            Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoventa.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(50);
            String sql = "SELECT * FROM proveedores";

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                nombre.getItems().add(resultSet.getString("nombre"));
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
            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Inicializando...");
        proveedores = new ArrayList<Proveedor>();
        cargarCombo();

        nombre.setOnAction(e ->  {
            index = nombre.getSelectionModel().getSelectedIndex();
            if(index<0)
                return;

            rfc.setText(proveedores.get(index).getRfc());
            calle.setText(proveedores.get(index).getCalle());
            colonia.setText(proveedores.get(index).getColonia());
            ciudad.setText(proveedores.get(index).getCiudad());
            pais.setText(proveedores.get(index).getPais());
            telefono.setText(proveedores.get(index).getTelefono());
            celular.setText(proveedores.get(index).getCelular());
            email.setText(proveedores.get(index).getEmail());

        });

    }
}
