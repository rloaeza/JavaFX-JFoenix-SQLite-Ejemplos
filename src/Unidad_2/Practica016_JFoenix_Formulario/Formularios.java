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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    private void mostrarPane(String pane) {
        switch (pane) {
            case "Usuario":
                if( paneUsuario.isVisible()) {
                    paneUsuario.setVisible(false);
                    upUsuario.setVisible(false);
                    return;
                }
                break;
            case "Escuela":
                if( paneEscuela.isVisible()) {
                    paneEscuela.setVisible(false);
                    upEscuela.setVisible(false);
                    return;
                }
                break;
            case "Mapa":
                if( paneMapa.isVisible()) {
                    paneMapa.setVisible(false);
                    upMapa.setVisible(false);
                    return;
                }
                break;
        }

        paneUsuario.setVisible(false);
        paneMapa.setVisible(false);
        paneEscuela.setVisible(false);
        upUsuario.setVisible(false);
        upEscuela.setVisible(false);
        upMapa.setVisible(false);

        switch (pane) {
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
    private double posX, posY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.
                load(getClass().getResource("Formularios.fxml"));


        layout.setOnMousePressed(e -> {
            posX = primaryStage.getX()-e.getX();
            posY = primaryStage.getY()-e.getY();
           // System.out.println("0: "+ posX + ", " + posY);
            //System.out.println("1: "+primaryStage.getX() + ", " + primaryStage.getY());
        });

        layout.setOnMouseDragged(e -> {
            primaryStage.setX(e.getX()+posX);
            primaryStage.setY(e.getY()+posY);
        });

        Scene scene = new Scene(layout);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
