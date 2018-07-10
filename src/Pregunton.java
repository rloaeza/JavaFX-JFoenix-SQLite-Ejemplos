import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class Pregunton extends Application {
    String txt = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";


    private ArrayList<Pregunta> preguntas;
    private int indicePreguntaActual;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label pregunta = new Label(txt);
        ComboBox<String> respuestas = new ComboBox<String>();
        Label resultado = new Label("Correcto / Incorrecto");
        Button anterior= new Button("Anterior");
        Button siguiente = new Button("Siguiente");
        CheckBox mostrarRespuesta =new CheckBox("Mostrar respuesta correcta");
        Label respuestaCorrecta=new Label(txt);

        HBox layoutBotones = new HBox();
        layoutBotones.setSpacing(10);
        layoutBotones.getChildren().addAll(anterior, siguiente);
        anterior.setPrefSize(195, 30);
        siguiente.setPrefSize(195, 30);

        respuestas.setPrefWidth(400);
        respuestas.setPromptText("Elige una respuesta");


        pregunta.setPrefWidth(400);
        pregunta.setPrefHeight(200);
        pregunta.setWrapText(true);


        resultado.setPrefWidth(400);
        resultado.setAlignment(Pos.CENTER);

        respuestaCorrecta.setPrefWidth(400);
        respuestaCorrecta.setPrefHeight(50);
        respuestaCorrecta.setWrapText(true);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(15);
        layout.getChildren().addAll(pregunta, respuestas, layoutBotones, resultado,
                                    mostrarRespuesta, respuestaCorrecta);




        respuestaCorrecta.setVisible(false);
        mostrarRespuesta.setOnAction( e -> {
            if(mostrarRespuesta.isSelected()) {
                respuestaCorrecta.setVisible(true);
            }else {
                respuestaCorrecta.setVisible(false);
            }
        });


        cargarPreguntas();
        mostrarPregunta(pregunta, respuestas, respuestaCorrecta);

        respuestas.setOnAction(e -> {
            if(respuestas.getSelectionModel().getSelectedIndex() ==
                    preguntas.get(indicePreguntaActual).getIndiceCorrecto()
                    ) {
                resultado.setText("Correcto");
            }else {
                resultado.setText("Incorrecto");
            }


        });

        siguiente.setOnAction(e-> {
            if(indicePreguntaActual== preguntas.size()-1)
                return;
            resultado.setText("");
            indicePreguntaActual++;

            mostrarPregunta(pregunta, respuestas, respuestaCorrecta);
        });


        anterior.setOnAction(e-> {
            if(indicePreguntaActual== 0)
                return;
            indicePreguntaActual--;
            resultado.setText("");
            mostrarPregunta(pregunta, respuestas, respuestaCorrecta);


        });















        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Preguntón");
        primaryStage.show();

    }

    private void mostrarPregunta(Label pregunta, ComboBox respuestas, Label respuestaCorrecta) {
        pregunta.setText(preguntas.get(indicePreguntaActual).getPregunta());

        respuestas.getItems().clear();


        for(String r : preguntas.get(indicePreguntaActual).getRespuestas()) {
            respuestas.getItems().add(r);
        }

        respuestaCorrecta.setText(preguntas.get(indicePreguntaActual)
                .getRespuestas()[preguntas.get(indicePreguntaActual)
                .getIndiceCorrecto()]);

    }

    private void cargarPreguntas() {
        indicePreguntaActual = 0;
        preguntas = new ArrayList<Pregunta>();
        preguntas.add(
                new Pregunta("¿Cuánto es 1 +1?",
                        new String[] {"1", "2", "3", "4"},
                        1));
        preguntas.add(
                new Pregunta("¿Cuántos planetas tiene nuestro sistema solar",
                        new String[] {"10", "2", "3", "8", "11"},
                        3));
    }
}
