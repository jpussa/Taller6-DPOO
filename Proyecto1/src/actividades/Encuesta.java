package actividades;

import java.util.Date;
import java.util.List;
import preguntas.Pregunta;

public class Encuesta extends Activity {
    private List<Pregunta> preguntas;

    public Encuesta(String titulo, String descripcion, Date fecha, List<Pregunta> preguntas) {
        super(titulo, descripcion, fecha);
        this.preguntas = preguntas;
    }
    public boolean completar() {
        return true;
    }
}