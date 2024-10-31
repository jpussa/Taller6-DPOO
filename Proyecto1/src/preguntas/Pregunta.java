package preguntas;

import java.util.List;

public class Pregunta {
    private String enunciado;
    private List<String> opciones; // Lista de opciones de respuesta
    private int indiceRespuestaCorrecta; // Índice de la respuesta correcta en la lista de opciones

    // Constructor
    public Pregunta(String enunciado, List<String> opciones, int indiceRespuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }

    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    
    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    
    public int getIndiceRespuestaCorrecta() {
        return indiceRespuestaCorrecta;
    }

    public void setIndiceRespuestaCorrecta(int indiceRespuestaCorrecta) {
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }

    
    public boolean verificarRespuesta(int indiceSeleccionado) {
        return indiceSeleccionado == indiceRespuestaCorrecta;
    }

    
    public void mostrarPregunta() {
        System.out.println(enunciado);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }
}