package Unidad_1.Controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Practica008_Label_Button_TextField_1 extends Application implements  EventHandler<ActionEvent>{


    private TextField textFieldResultado;
    private Button botonLimpiar;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage escenarioPrincipal) {


        GridPane contenedor = new GridPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setVgap(10);

        Label titulo = new Label("Operaciones básicas");

        Label labelValor1 = new Label("Valor 1:");
        Label labelValor2 = new Label("Valor 2:");
        Label labelResultado = new Label("Resultado:");

        labelValor1.setPrefWidth(100);
        labelValor1.setMinWidth(50);

        TextField textFieldValor1 = new TextField();
        TextField textFieldValor2 = new TextField();
        textFieldResultado = new TextField();



        Button botonSumar = new Button("Sumar");
        botonSumar.setMaxWidth(Double.MAX_VALUE);


        Button botonRestar = new Button("Restar");
        botonLimpiar = new Button("Limpiar resultado");


        contenedor.add(titulo, 1, 0, 2, 1);
        contenedor.add(labelValor1, 0,1);   contenedor.add(textFieldValor1, 1,1);
        contenedor.add(labelValor2, 0,2);   contenedor.add(textFieldValor2, 1, 2);

        contenedor.add(botonSumar, 1,3, 2,1);
        contenedor.add(botonRestar, 1,4);
        contenedor.add(botonLimpiar, 1,5);

        contenedor.add(labelResultado, 0,6);
        contenedor.add(textFieldResultado, 1, 6);




        botonSumar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double v1 = Double.valueOf(textFieldValor1.getText());
                double v2 = Double.valueOf(textFieldValor2.getText());

                textFieldResultado.setText( String.valueOf( v1 + v2 ));

            }
        });

        botonRestar.setOnAction(event -> {
            double v1 = Double.valueOf(textFieldValor1.getText());
            double v2 = Double.valueOf(textFieldValor2.getText());

            textFieldResultado.setText( String.valueOf( v1 - v2 ));

        });

        botonLimpiar.setOnAction( this );

        Scene escena = new Scene(contenedor);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    @Override
    public void handle(ActionEvent event) {

        if( event.getSource() == botonLimpiar){
            textFieldResultado.setText("");
        }
    }
}
