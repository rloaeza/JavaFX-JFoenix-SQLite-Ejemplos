package Unidad_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Calculadora extends Application {

    private double numero1;
    private String operacion;

    @FXML
    private TextField display;

    @FXML
    void accionBasica(ActionEvent event) {
        numero1 = Double.valueOf(display.getText());
        display.setText("0");
        operacion = ((Button)event.getSource())
                .getText();

    }

    @FXML
    void accionIgual(ActionEvent event) {
        double numero2 = Double.valueOf(display.getText());
        double resultado=0;

        switch (operacion) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                resultado = numero1 / numero2;
                break;
        }
        display.setText(String.valueOf(resultado));
    }

    @FXML
    void agregaDigito(ActionEvent event) {
        Button boton = (Button)event.getSource();
        String digito = boton.getText();

        if(display.getText().equalsIgnoreCase("0")) {
            display.setText(digito);
        }
        else {
            display.setText(display.getText()+digito);
        }


    }
    @FXML
    void agregaPunto(ActionEvent event) {

        if( display.getText().contains(".") == false ) {
            display.setText(display.getText()+".");
        }

    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);

    }


    @FXML
    void limpiarEntrada(ActionEvent event) {
        display.setText("0");
    }

    @FXML
    void limpiarTodo(ActionEvent event) {
        numero1 = 0;
        operacion= "";
        display.setText("0");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent layout = FXMLLoader.load(getClass().getResource("Calculadora.fxml"));

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora Básica");
        primaryStage.show();
    }
}
