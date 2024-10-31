package actividades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import preguntas.Pregunta;

public class Quiz extends Activity {
	private Long id;
    
    private static final String TIPO = "Quiz";
    private double calificacionMinima;
    private double calificacionFinal;
    private List<Pregunta> preguntas;

    public Quiz(String titulo, Boolean obligatoriedad, String descripcion, String objetivo,
            String nivelDificultad, int duracion, String creador, double calificacionMinima) throws Exception {
    super(titulo, TIPO, obligatoriedad, descripcion, objetivo, nivelDificultad, duracion, creador); // Llamada a super para inicializar 'creador'
    this.calificacionMinima = calificacionMinima;
    this.calificacionFinal = 0;
    this.preguntas = new ArrayList<>();
}
    public Quiz(String titulo, String descripcion, Date fecha, double calificacionMinima, List<Pregunta> preguntas) {
        super(titulo, descripcion, fecha);
        this.calificacionMinima = calificacionMinima;
        this.preguntas = preguntas;
    }
    public double getCalificacionMinima() {
        return calificacionMinima;
    }

    public void setCalificacionMinima(double calificacionMinima) {
        this.calificacionMinima = calificacionMinima;
    }

    public double getCalificacionFinal() {
        return calificacionFinal;
    }

    public List<Pregunta> getPreguntas() {
        return new ArrayList<>(preguntas);
    }

    public void agregarPregunta(Pregunta pregunta) {
        if (pregunta != null) {
            preguntas.add(pregunta);
        }
    }

    // Método que evalúa las respuestas y calcula la calificación final
    private void evaluarRespuestas() {
        int totalPreguntas = preguntas.size();
        if (totalPreguntas == 0) {
            calificacionFinal = 0; // Sin preguntas, calificación final es 0
            return;
        }

        long respuestasCorrectas = 0; // Contador de respuestas correctas
        for (Pregunta pregunta : preguntas) {
            if (pregunta.verificarRespuesta(totalPreguntas)) { // Verifica cada respuesta
                respuestasCorrectas++;
            }
        }
        
        calificacionFinal = ((double) respuestasCorrectas / totalPreguntas) * 5; // Calcula la calificación
    }


    // Muestra explicaciones detalladas para cada pregunta y su respuesta
    public String mostrarExplicaciones() {
        StringBuilder explicacionesCompletas = new StringBuilder();
        preguntas.forEach(pregunta -> {
            explicacionesCompletas.append(pregunta.getEnunciado())
                                  .append("\n")
                                  .append(pregunta.explicaciones())
                                  .append("\n");
        });
        return explicacionesCompletas.toString();
    }

    // Envía el quiz, calcula el tiempo dedicado y actualiza el resultado
    public void enviar() {
        LocalDateTime horaActual = LocalDateTime.now();
        evaluarRespuestas();
        actualizarResultado();
    }

    // Actualiza el resultado del quiz basado en la calificación mínima
    private void actualizarResultado() {
        setResultado(calificacionFinal >= calificacionMinima ? "Exitoso" : "No exitoso");
    }
    public void setId(Long id) {
    	this.id = id;
    }


	@Override
	public boolean completar() {
		// TODO Auto-generated method stub
		return false;
	}
}