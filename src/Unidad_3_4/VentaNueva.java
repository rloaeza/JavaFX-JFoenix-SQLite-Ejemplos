package Unidad_3_4;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentaNueva implements Initializable {

    private ArrayList<VentaListaProductos> productos;
    private ObservableList<Venta> elementosTabla;


    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField producto;

    @FXML
    private JFXListView<String> listaProductos;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private TableView<Venta> tabla;

    @FXML
    private Label granTotal;

    private double calcularTotal () {
        double total = 0;
        for(Venta v : elementosTabla) {
            total += v.getCosto()*v.getCantidad();
        }
        return total;
    }

    @FXML
    void AgregarProducto(ActionEvent event) {
        int indiceLista = listaProductos.getSelectionModel().getSelectedIndex();
        if(indiceLista<0)
            return;
        int idProducto = productos.get(indiceLista).getIdProducto();
        int idExistencia =productos.get(indiceLista).getIdExistencia();
        double costo =productos.get(indiceLista).getCosto();
        String nombreProducto = productos.get(indiceLista).getNombre();


        int cantidadProducto = cantidad.getText().isEmpty()?1:Integer.valueOf(cantidad.getText());

        elementosTabla.add(new Venta(idExistencia, idProducto, cantidadProducto, nombreProducto, costo));

        granTotal.setText(String.valueOf(calcularTotal()));

        producto.setText("");
        listaProductos.getItems().clear();
        productos.clear();
    }

    @FXML
    void Quitar(ActionEvent event) {
        int indice = tabla.getSelectionModel().getSelectedIndex();
        if(indice<0)
            return;
        elementosTabla.remove(indice);

        granTotal.setText(String.valueOf(calcularTotal()));

    }
    @FXML
    void Cancelar(ActionEvent event) {
        Pane p = (Pane)contenedor.getParent();
        p.getChildren().remove(0);
    }

    @FXML
    void Guardar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        producto.setOnKeyTyped(e->{
            String patron = producto.getText();

            if(patron.length()>3) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:pventa.db");
                    Statement statement = connection.createStatement();
                    statement.setQueryTimeout(60);
                    String sql = "SELECT * FROM productos, existencias WHERE productos.idProducto=existencias.idProducto AND ( nombre LIKE '%"+patron+"%' OR descripcion LIKE '%"+patron+"%' )";
                    productos = new ArrayList<VentaListaProductos>();
                    listaProductos.getItems().clear();
                    ResultSet resultSet = statement.executeQuery(sql);
                    while(resultSet.next()) {
                        listaProductos.getItems().add(resultSet.getString("nombre"));

                        productos.add(new VentaListaProductos(
                                resultSet.getInt("idProducto"),
                                resultSet.getInt("idProveedor"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getInt("idExistencia"),
                                resultSet.getInt("cantidad"),
                                resultSet.getDouble("costo")
                                ));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });


        TableColumn<Venta, String> columnaCantidad= new TableColumn<>("Cantidad");
        columnaCantidad.setMinWidth(20);
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        TableColumn<Venta, String> columnaProducto= new TableColumn<>("Producto");
        columnaProducto.setMinWidth(300);
        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));

        TableColumn<Venta, String> columnaCosto= new TableColumn<>("Costo");
        columnaCosto.setMinWidth(50);
        columnaCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));


        elementosTabla = FXCollections.observableArrayList();
        tabla.setItems(elementosTabla);
        tabla.getColumns().clear();
        tabla.getColumns().addAll(columnaCantidad, columnaProducto, columnaCosto);


    }
}
