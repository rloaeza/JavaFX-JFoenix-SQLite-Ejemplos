package proyectoFinal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TODO extends Application implements Initializable {

    private ArrayList<TODOModel> todoModels;

    private boolean editandoNota;
    private int indice;
    private int id;

    @FXML
    private TilePane activas;

    @FXML
    private JFXCheckBox hecho;

    @FXML
    private JFXTextField titulo;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    private TilePane inactivas;

    @FXML
    private JFXButton NuevoEditar;

    @FXML
    void Salir(MouseEvent event ){
        Platform.exit();
    }

    @FXML
    void NuevaNota(MouseEvent event) {
        titulo.setText("");
        descripcion.setText("");
        hecho.setSelected(false);
        editandoNota = false;
        NuevoEditar.setText("Guardar Nuevo");
    }
    @FXML
    void NuevoEditar(ActionEvent event) {
        GridPane nuevo = crearNota(titulo.getText(), descripcion.getText(), hecho.isSelected());
        if( editandoNota) {
            todoModels.get(indice).setTitulo(titulo.getText());
            todoModels.get(indice).setDescripcion(descripcion.getText());
            todoModels.get(indice).setHecho(hecho.isSelected());
            activas.getChildren().set(indice, nuevo);
        }
        else {
            todoModels.add(new TODOModel(id, titulo.getText(), descripcion.getText(), hecho.isSelected()));
            activas.getChildren().add(nuevo);
        }

        titulo.setText("");
        descripcion.setText("");
        hecho.setSelected(false);
        editandoNota =false;
        NuevoEditar.setText("Guardar Nuevo");
    }

    private GridPane crearNota(String titulo, String descripcion, boolean activa) {
        GridPane nuevo = new GridPane();

        nuevo.setMaxWidth(250);
        nuevo.setMinWidth(250);

        nuevo.setVgap(10);
        nuevo.setHgap(10);
        nuevo.setPadding(new Insets(10));


        Label lTitulo =new Label(titulo);
        //lTitulo.setFont(Font.font("System", FontWeight.BOLD, 18));
        Reflection r = new Reflection();
        r.setFraction(0.5f);
        lTitulo.setEffect(r);

        nuevo.add( lTitulo, 0, 0);


        nuevo.add(new Label(descripcion), 0, 1);

        if(activa)
            nuevo.setStyle("-fx-background-color:#c9dbd2; -fx-opacity:1;");
        else
            nuevo.setStyle("-fx-background-color:#8fc4a8; -fx-opacity:1;");

        nuevo.setOnMouseClicked(e -> {
            indice = buscame((GridPane) e.getSource());
            this.titulo.setText(todoModels.get(indice).getTitulo());
            this.descripcion.setText(todoModels.get(indice).getDescripcion());
            this.hecho.setSelected(todoModels.get(indice).isHecho());
            this.editandoNota = true;
            this.NuevoEditar.setText("Actualizar");

        });
        return nuevo;
    }


    private int buscame(GridPane gridPane) {
        int i=0;
        for(Node g : activas.getChildren()) {
            if( gridPane== g) {
                return i;
            }
            i++;
        }
        return -1;
    }
    double posX, posY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("TODO.fxml"));
        Scene scene = new Scene(layout);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();


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


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activas.setHgap(10);
        activas.setVgap(10);
        todoModels = new ArrayList<>();
        editandoNota = false;

    }
}
