package Unidad_3_4;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentaNueva implements Initializable {

    private ArrayList<Cliente> clientes;

    private ArrayList<VentaProductoCosto> ventaProductoCostos;

    private ObservableList<VentaElementos> ventaElementos;

    private double calcularTotal() {
        double total = 0;
        
        for(VentaElementos v : ventaElementos) {
            total = total + v.getCostoT();
        }
        return total;
    }


    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField producto;

    @FXML
    private JFXListView<String> listaProductos;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private TableView<VentaElementos> tabla;

    @FXML
    private Label granTotal;

    @FXML
    private JFXComboBox<String> cliente;

    @FXML
    void AgregarProducto(ActionEvent event) {
        ventaElementos.add(new VentaElementos(1,1, 20, "Producto X", 20));
    }

    @FXML
    void Cancelar(ActionEvent event) {

    }

    @FXML
    void Guardar(ActionEvent event) {

    }

    @FXML
    void Quitar(ActionEvent event) {
        int indice = tabla.getSelectionModel().getSelectedIndex();
        if( indice<0 )
            return;

        ventaElementos.remove(indice);

        granTotal.setText(String.valueOf(calcularTotal()));


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM clientes";
            ResultSet resultSet = statement.executeQuery(sql);

            clientes = new ArrayList<Cliente>();
            cliente.getItems().clear();

            while(resultSet.next()) {
                cliente.getItems().add(resultSet.getString("nombre"));
                clientes.add(new Cliente(
                        resultSet.getInt("idCliente"),
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

        producto.setOnKeyTyped(e-> {
            String patron = producto.getText();
            if( patron.length()<3 )
                return;


            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
                Statement statement = connection.createStatement();

                String sql = "SELECT * FROM productos, existencias " +
                        "WHERE productos.idProducto=existencias.idProducto " +
                        "AND nombre LIKE '%" + patron + "%' " +
                        "AND cantidad > 0";

                ResultSet resultSet = statement.executeQuery(sql);
                ventaProductoCostos = new ArrayList<VentaProductoCosto>();
                listaProductos.getItems().clear();
                while(resultSet.next()) {
                    listaProductos.getItems().add(
                            resultSet.getString("nombre"));

                    ventaProductoCostos.add(new VentaProductoCosto(
                       resultSet.getInt("idProducto"),
                        resultSet.getInt("idExistencia"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("costo")
                    ));

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        });

        TableColumn<VentaElementos, String> columnaCantidad = new TableColumn<>("Cant.");
        columnaCantidad.setMinWidth(10);
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<VentaElementos, String> columnaNombre = new TableColumn<>("Nombre Producto");
        columnaNombre.setMinWidth(250);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<VentaElementos, String> columnaCostoU = new TableColumn<>("C. U.");
        columnaCostoU.setMinWidth(10);
        columnaCostoU.setCellValueFactory(new PropertyValueFactory<>("costoU"));

        TableColumn<VentaElementos, String> columnaCostoT = new TableColumn<>("C. T.");
        columnaCostoT.setMinWidth(10);
        columnaCostoT.setCellValueFactory(new PropertyValueFactory<>("costoT"));

        tabla.getColumns().clear();
        tabla.getColumns().addAll(columnaCantidad, columnaNombre, columnaCostoU, columnaCostoT);


        ventaElementos = FXCollections.observableArrayList();
        tabla.setItems(ventaElementos);



    }
}
