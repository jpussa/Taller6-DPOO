package actividades;

import java.util.Date;
import java.util.List;

public class Encuesta extends Activity {
    private List<String> preguntas;

    public Encuesta(String titulo, String descripcion, Date fecha, List<String> preguntas) {
        super(titulo, descripcion, fecha);
        this.preguntas = preguntas;
    }

    @Override
    public boolean completar() {
        return true;
    }
}