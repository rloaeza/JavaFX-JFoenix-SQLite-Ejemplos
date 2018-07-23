package Unidad_2.Practica016_JFoenix_Formulario;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Formularios extends Application {

    @FXML
    private ImageView bUsuario;

    @FXML
    private ImageView bMapa;

    @FXML
    private ImageView bEscuela;

    @FXML
    private ImageView bSalir;

    @FXML
    private AnchorPane paneUsuario;

    @FXML
    private AnchorPane paneMapa;

    @FXML
    private AnchorPane paneEscuela;

    @FXML
    private ImageView upUsuario;

    @FXML
    private ImageView upMapa;

    @FXML
    private ImageView upEscuela;

    @FXML
    void mostrarEscuela(MouseEvent event) {
        mostrarPane("Escuela");
    }

    @FXML
    void mostrarMapa(MouseEvent event) {
        mostrarPane("Mapa");
    }

    @FXML
    void mostrarUsuario(MouseEvent event) {
        mostrarPane("Usuario");
    }

    @FXML
    void salir(MouseEvent event) {
        Platform.exit();

    }

    private void mostrarPane(String opc) {
        paneUsuario.setVisible(false);
        paneMapa.setVisible(false);
        paneEscuela.setVisible(false);
        upUsuario.setVisible(false);
        upEscuela.setVisible(false);
        upMapa.setVisible(false);

        switch (opc) {
            case "Usuario":
                paneUsuario.setVisible(true);
                upUsuario.setVisible(true);
                break;
            case "Mapa":
                paneMapa.setVisible(true);
                upMapa.setVisible(true);
                break;
            case "Escuela":
                paneEscuela.setVisible(true);
                upEscuela.setVisible(true);
                break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.
                load(getClass().getResource("Formularios.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
