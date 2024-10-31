package actividades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import preguntas.Pregunta;

public class Quiz extends Activity {
    
    private static final String TIPO = "Quiz";
    private double calificacionMinima;
    private double calificacionFinal;
    private List<Pregunta> preguntas;

    public Quiz(String titulo, Boolean obligatoriedad, String descripcion, String objetivo,
                String nivelDificultad, int duracion, String creador, double calificacionMinima) throws Exception {
        super(titulo, TIPO, obligatoriedad, descripcion, objetivo, nivelDificultad, duracion, creador);
        this.calificacionMinima = calificacionMinima;
        this.calificacionFinal = 0;
        this.preguntas = new ArrayList<>();
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
            calificacionFinal = 0;
            return;
        }

        long respuestasCorrectas = preguntas.stream().filter(preguntas::verificarRespuesta).count();
        calificacionFinal = ((double) respuestasCorrectas / totalPreguntas) * 5;
    }

    // Muestra explicaciones detalladas para cada pregunta y su respuesta
    public String mostrarExplicaciones() {
        StringBuilder explicacionesCompletas = new StringBuilder();
        preguntas.forEach(pregunta -> {
            explicacionesCompletas.append(pregunta.getDescripcion())
                                  .append("\n")
                                  .append(pregunta.explicaciones())
                                  .append("\n");
        });
        return explicacionesCompletas.toString();
    }

    // Envía el quiz, calcula el tiempo dedicado y actualiza el resultado
    public void enviar() {
        LocalDateTime horaActual = LocalDateTime.now();
        setHoraFin(horaActual);
        calcularTiempoDedicado(horaInicio, horaFin);
        evaluarRespuestas();
        actualizarResultado();
    }

    // Actualiza el resultado del quiz basado en la calificación mínima
    private void actualizarResultado() {
        setResultado(calificacionFinal >= calificacionMinima ? "Exitoso" : "No exitoso");
    }

    // Crea una copia de esta instancia de Quiz para otro usuario
    public Quiz copiarActividad(String usuario) throws Exception {
        String nuevoTitulo = "Copia de " + getTitulo() + " de " + creador;
        String nuevoCreador = creador.equalsIgnoreCase(usuario) ? creador : usuario;

        Quiz copia = new Quiz(nuevoTitulo, getObligatoriedad(), getDescripcion(), getObjetivo(),
                              getNivelDificultad(), getDuracion(), nuevoCreador, calificacionMinima);

        copia.setFeedbacks(new ArrayList<>(getFeedbacks()));
        copia.setPrerrequisitos(new HashMap<>(getPrerrequisitos()));
        copia.setRecomendacionesAprobado(new HashMap<>(getRecomendacionesAprobado()));
        copia.setRecomendacionesNoAprobado(new HashMap<>(getRecomendacionesNoAprobado()));
        copia.setPreguntas(new ArrayList<>(preguntas));

        return copia;
    }

	@Override
	public boolean completar() {
		// TODO Auto-generated method stub
		return false;
	}
}