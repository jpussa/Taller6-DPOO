package actividades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import preguntas.Pregunta;
import java.util.HashMap;
import java.util.Map;

public class Encuesta extends Activity {
	private Long id;
    private static final String TIPO = "Encuesta";
    private List<Pregunta> preguntas; // Lista de preguntas de la encuesta
    private Map<Pregunta, List<String>> respuestas; // Almacena las respuestas de los usuarios

    public Encuesta(String titulo, Boolean obligatoriedad, String descripcion, String objetivo,
                    String nivelDificultad, int duracion, String creador) throws Exception {
        super(titulo, TIPO, obligatoriedad, descripcion, objetivo, nivelDificultad, duracion, creador);
        this.preguntas = new ArrayList<>();
        this.respuestas = new HashMap<>();
    }
    public Encuesta(String titulo, String descripcion, Date fecha, List<Pregunta> preguntas2) {
        super(titulo, descripcion, fecha);
        this.preguntas = preguntas2;
    }



	// Método para agregar una pregunta a la encuesta
    public void agregarPregunta(Pregunta pregunta) {
        if (pregunta != null) {
            preguntas.add(pregunta);
            respuestas.put(pregunta, new ArrayList<>()); // Inicializa la lista de respuestas para cada pregunta
        }
    }

    // Método para agregar una respuesta a una pregunta específica
    public void agregarRespuesta(Pregunta pregunta, String respuesta) {
        if (respuestas.containsKey(pregunta)) {
            respuestas.get(pregunta).add(respuesta);
        } else {
            System.out.println("La pregunta no existe en la encuesta.");
        }
    }

    // Método para obtener las preguntas de la encuesta
    public List<Pregunta> getPreguntas() {
        return new ArrayList<>(preguntas);
    }

    // Método para obtener las respuestas de una pregunta específica
    public List<String> obtenerRespuestas(Pregunta pregunta) {
        return respuestas.getOrDefault(pregunta, new ArrayList<>());
    }
    

    // Método para mostrar la encuesta con preguntas y respuestas
    public void mostrarEncuesta() {
        System.out.println("Encuesta: " + getTitulo());
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta.getEnunciado());
            List<String> respuestasPregunta = obtenerRespuestas(pregunta);
            if (respuestasPregunta.isEmpty()) {
                System.out.println("Sin respuestas aún.");
            } else {
                System.out.println("Respuestas:");
                for (String respuesta : respuestasPregunta) {
                    System.out.println("- " + respuesta);
                }
            }
        }
    }

    // Envía la encuesta y finaliza el proceso
    public void enviar() {
        setResultado("Encuesta completada");
    }

    public boolean completar() {
        enviar();
        return true; // Indica que la encuesta se completó satisfactoriamente
    }
	public void setId(Long id) {
		this.id = id;
		
	}
}
