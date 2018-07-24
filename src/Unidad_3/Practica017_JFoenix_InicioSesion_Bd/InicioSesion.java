package Unidad_3.Practica017_JFoenix_InicioSesion_Bd;

import Tema1.AlertBox;
import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class InicioSesion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().
        getResource("InicioSesion.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Genius Coder: Inicio de sesión");
        primaryStage.show();
    }

    @FXML
    private JFXButton bConectar;

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField clave;

    @FXML
    void conectar(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:basedatos1.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            String usr = usuario.getText();
            String clv = clave.getText();

            String consulta = "SELECT * FROM usuarios " +
                    "WHERE correo='"+usr+"' AND clave='"+clv+"' ";


            ResultSet rs = statement.executeQuery(consulta);
            if(rs.next()) {

                System.out.println("Usuario correcto: "+ rs.getString("nombre"));

            }
            else {
                System.out.println("Usuario no correcto: ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
