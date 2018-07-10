package Unidad_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.nio.DoubleBuffer;

public class Evaluacion1 extends Application {
    private double n1;
    private double n2;
    private double nr;
    char opc;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        int alto = 50;
        int ancho = 110;
        int separador = 15;
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b0 = new Button("0");
        Button bp = new Button(".");
        Button bIgual = new Button("=");
        Button bMas = new Button("+");
        Button bMenos = new Button("-");
        Button bPor = new Button("*");
        Button bEntre = new Button("/");

        Button bLipmiarTodo = new Button("Limpiar todo");
        Button bLimpiar = new Button("Limpiar");

        TextField resultado = new TextField("0");

        b1.setPrefSize(ancho, alto);
        b2.setPrefSize(ancho, alto);
        b3.setPrefSize(ancho, alto);
        b4.setPrefSize(ancho, alto);
        b5.setPrefSize(ancho, alto);
        b6.setPrefSize(ancho, alto);
        b7.setPrefSize(ancho, alto);
        b8.setPrefSize(ancho, alto);
        b9.setPrefSize(ancho, alto);
        bMas.setPrefSize(ancho, alto);
        bMenos.setPrefSize(ancho, alto);
        bPor.setPrefSize(ancho, alto);
        bEntre.setPrefSize(ancho, alto);
        bp.setPrefSize(ancho, alto);
        bIgual.setPrefSize(ancho, alto);
        bLimpiar.setPrefSize(ancho, alto);
        b0.setPrefSize(2*ancho+separador, alto);
        bLipmiarTodo.setPrefSize(2*ancho+separador, alto);



        resultado.setPrefSize(4*ancho + 3*separador, alto);
        resultado.setAlignment(Pos.CENTER_RIGHT);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(separador*2));
        layout.setHgap(separador);
        layout.setVgap(separador);

        layout.add(resultado, 0,0, 4,1);

        layout.add(b0, 0, 5, 2, 1);
        layout.add(bp, 2, 5);
        layout.add(bIgual, 3, 5);

        layout.add(b1, 0, 4);
        layout.add(b2, 1, 4);
        layout.add(b3, 2, 4);
        layout.add(bMas, 3, 4);

        layout.add(b4, 0, 3);
        layout.add(b5, 1, 3);
        layout.add(b6, 2, 3);
        layout.add(bMenos, 3, 3);

        layout.add(b7, 0, 2);
        layout.add(b8, 1, 2);
        layout.add(b9, 2, 2);
        layout.add(bPor, 3, 2);

        layout.add(bLipmiarTodo, 0, 1, 2,1);
        layout.add(bLimpiar, 2, 1);
        layout.add(bEntre, 3, 1);


        b1.setOnAction(e -> agregarValor("1", resultado) );
        b2.setOnAction(e -> agregarValor("2", resultado) );
        b3.setOnAction(e -> agregarValor("3", resultado) );
        b4.setOnAction(e -> agregarValor("4", resultado) );
        b5.setOnAction(e -> agregarValor("5", resultado) );
        b6.setOnAction(e -> agregarValor("6", resultado) );
        b7.setOnAction(e -> agregarValor("7", resultado) );
        b8.setOnAction(e -> agregarValor("8", resultado) );
        b9.setOnAction(e -> agregarValor("9", resultado) );
        b0.setOnAction(e -> agregarValor("0", resultado) );


        bLimpiar.setOnAction(e-> resultado.setText("0"));
        bLipmiarTodo.setOnAction(e-> {
            resultado.setText("0");
            n1 = 0;
            opc = '?';
        });
        bp.setOnAction(e -> {
            if( resultado.getText().contains(".") == false ){
                resultado.setText(resultado.getText()+".");
            }
        });

        bMas.setOnAction(e -> fijarOperador('+', resultado) );
        bMenos.setOnAction(e -> fijarOperador('-', resultado) );
        bPor.setOnAction(e -> fijarOperador('*', resultado) );
        bEntre.setOnAction(e -> fijarOperador('/', resultado) );

        bIgual.setOnAction(e->{
            switch (opc){
                case '+':
                    n2 = Double.valueOf(resultado.getText());
                    nr = n1 + n2;
                    n1 = n2;
                    break;
                case '-':
                    n2 = Double.valueOf(resultado.getText());
                    nr = n1 - n2;
                    n1 = n2;
                    break;
                case '*':
                    n2 = Double.valueOf(resultado.getText());
                    nr = n1 * n2;
                    n1 = n2;
                    break;
                case '/':
                    n2 = Double.valueOf(resultado.getText());
                    nr = n1 / n2;
                    n1 = n2;
                    break;
                default:
                    n1 = Double.valueOf(resultado.getText());
                    nr = 0;
            }

            double resultadoEntero = (int)nr;
            if(resultadoEntero == nr)
                resultado.setText(String.valueOf((int)resultadoEntero));
            else
                resultado.setText(String.valueOf(nr));
        });

        Scene escena = new Scene(layout);
        primaryStage.setScene(escena);
        primaryStage.show();

    }

    private void fijarOperador(char oper, TextField r) {
        opc = oper;
        n1 = Double.valueOf(r.getText());
        r.setText("0");

    }
    private void agregarValor(String valor, TextField r) {

        if(Double.valueOf(r.getText())==0 && r.getText().contains(".")==false){
            r.setText(valor);
        }
        else {
            r.setText(r.getText()+valor);
        }
    }
}
