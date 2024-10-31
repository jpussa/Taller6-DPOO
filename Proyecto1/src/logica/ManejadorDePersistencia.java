package logica;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import actividades.Activity;
import actividades.Encuesta;
import actividades.Quiz;
import actividades.Tarea;
import preguntas.Pregunta;

public class ManejadorDePersistencia {
    private static final String ACTIVITIES_FILE = "./data/activities.txt";
    private static final String LEARNING_PATHS_FILE = "./data/learningPaths.txt";
    
    // Almacena las actividades y los LearningPaths
    private HashMap<Long, Activity> actividades = new HashMap<>();
    private HashMap<Long, LearningPath> learningPaths = new HashMap<>();

    // Guarda las actividades en un archivo
    public void guardarActividades() throws IOException {
        try (PrintWriter escritor = new PrintWriter(new File(ACTIVITIES_FILE))) {
            for (Activity actividad : actividades.values()) {
                guardarActividad(actividad, escritor);
            }
        }
    }

    // Guarda una actividad en el archivo
    private void guardarActividad(Activity actividad, PrintWriter escritor) {
        String tipo = actividad.getClass().getSimpleName(); // Tipo de actividad
        escritor.print(tipo + ";" + actividad.getId() + ";" + actividad.getTitulo() + ";" + actividad.getDescripcion() + ";" + actividad.getFecha());

        if (actividad instanceof Encuesta) {
            Encuesta encuesta = (Encuesta) actividad;
            escritor.print(";" + encuesta.getPreguntas().size());
            for (Pregunta pregunta : encuesta.getPreguntas()) {
                escritor.print(";" + pregunta);
            }
        } else if (actividad instanceof Quiz) {
            Quiz quiz = (Quiz) actividad;
            escritor.print(";" + quiz.getCalificacionMinima());
            // Aquí puedes agregar la lógica para las preguntas del Quiz
        } else if (actividad instanceof Tarea) {
            Tarea tarea = (Tarea) actividad;
            escritor.print(";" + tarea.getEntrega() + ";" + tarea.getestado());
        }
        escritor.println(); // Nueva línea para la siguiente actividad
    }

    // Lee las actividades desde el archivo
    public void leerActividades() throws IOException {
        actividades.clear(); // Limpiar antes de cargar
        try (BufferedReader lector = new BufferedReader(new FileReader(ACTIVITIES_FILE))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                Activity actividad = leerActividad(linea);
                if (actividad != null) {
                    actividades.put(actividad.getId(), actividad);
                }
            }
        }
    }

    // Lee una actividad desde una línea
    private Activity leerActividad(String linea) {
        String[] datos = linea.split(";");
        String tipo = datos[0];
        Long id = Long.parseLong(datos[1]); // Convertir ID a Long
        String titulo = datos[2];
        String descripcion = datos[3];
        Date fecha = new Date(); // Debes parsear correctamente la fecha de datos[4]

        switch (tipo) {
            case "Encuesta":
                List<String> preguntas = new ArrayList<>();
                int numPreguntas = Integer.parseInt(datos[5]);
                for (int i = 0; i < numPreguntas; i++) {
                    preguntas.add(datos[6 + i]);
                }
                Encuesta encuesta = new Encuesta(titulo, descripcion, fecha, preguntas);
                encuesta.setId(id); // Establecer el ID
                return encuesta;
            case "Quiz":
                double calificacionMinima = Double.parseDouble(datos[5]); // Cambia de float a double
                // Aquí debes manejar la lectura de preguntas del Quiz
                Quiz quiz = new Quiz(titulo, descripcion, fecha, calificacionMinima, new ArrayList<>()); // Placeholder para preguntas
                quiz.setId(id); // Establecer el ID
                return quiz;
            case "Tarea":
                String entrega = datos[5];
                String estado = datos[6];
                Tarea tarea = new Tarea(titulo, descripcion, fecha, entrega);
                tarea.setEstado(estado);
                tarea.setId(id); // Establecer el ID
                return tarea;
            default:
                return null; // Tipo no reconocido
        }
    }

    // Métodos para guardar y leer LearningPaths
    public void guardarLearningPaths() throws IOException {
        // Implementación para guardar LearningPaths similar a guardarActividades
    }

    public void leerLearningPaths() throws IOException {
        // Implementación para leer LearningPaths similar a leerActividades
    }

    // Métodos para acceder a las actividades y LearningPaths
    public HashMap<Long, Activity> getActividades() {
        return actividades;
    }

    public HashMap<Long, LearningPath> getLearningPaths() {
        return learningPaths;
    }

    // Métodos para añadir y eliminar actividades o LearningPaths si es necesario
}