package actividades;
import java.util.Date;
import java.util.List;

public class Quiz extends Activity {
    private List<pregunta> preguntas;
    private float calificacionMinima;

    public Quiz(String titulo, String descripcion, Date fecha, float calificacionMinima, List<Question> preguntas) {
        super(titulo, descripcion, fecha);
        this.calificacionMinima = calificacionMinima;
        this.preguntas = preguntas;
    }

    @Override
    public boolean completar() {
        // Lógica para completar el quiz
        return false;
    }
}