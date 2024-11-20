package logica;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
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
        escritor.print(tipo + ";" + actividad.getId() + ";" + actividad.getTitulo() + ";" + actividad.getDescripcion()
                + ";" + actividad.getFecha());

        if (actividad instanceof Encuesta) {
            Encuesta encuesta = (Encuesta) actividad;
            escritor.print(";" + encuesta.getPreguntas().size());
            for (Pregunta pregunta : encuesta.getPreguntas()) {
                escritor.print(";" + pregunta);
            }
        } else if (actividad instanceof Quiz) {
            Quiz quiz = (Quiz) actividad;
            escritor.print(";" + quiz.getCalificacionMinima());
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
        Long id = Long.parseLong(datos[1]);
        String titulo = datos[2];
        String descripcion = datos[3];

        Date fecha;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(datos[4]);
        } catch (Exception e) {
            fecha = new Date(); // Valor por defecto si no se puede analizar la fecha
        }

        switch (tipo) {
            case "Encuesta":
                int numPreguntasEncuesta = Integer.parseInt(datos[5]);
                List<Pregunta> preguntas = new ArrayList<>();
                for (int i = 0; i < numPreguntasEncuesta; i++) {
                    int questionOffset = i * 3; // Offset para las preguntas
                    String enunciado = datos[6 + questionOffset];
                    String[] opciones = datos[7 + questionOffset].split(",");
                    int indiceCorrecto = Integer.parseInt(datos[8 + questionOffset]);
                    Pregunta pregunta = new Pregunta(enunciado, Arrays.asList(opciones), indiceCorrecto);
                    preguntas.add(pregunta);
                }
                Encuesta encuesta = new Encuesta(titulo, descripcion, fecha, preguntas);
                encuesta.setId(id);
                return encuesta;
            case "Quiz":
            	List<Pregunta> preguntasQ = new ArrayList<>();
                int calificacionMinima = Integer.parseInt(datos[5]);
                Quiz quiz = new Quiz(titulo, descripcion, fecha, calificacionMinima, preguntasQ);
                quiz.setId(id);
                return quiz;
            case "Tarea":
                String entrega = datos[5];
                String estado = datos[6];
                Tarea tarea = new Tarea(titulo, descripcion, fecha, entrega);
                tarea.setEstado(estado);
                tarea.setId(id);
                return tarea;
            default:
                return null; // Tipo no reconocido
        }
    }

    // Métodos para guardar y leer LearningPaths
    public void guardarLearningPaths() throws IOException {
        try (PrintWriter escritor = new PrintWriter(new File(LEARNING_PATHS_FILE))) {
            for (LearningPath learningPath : learningPaths.values()) {
                guardarLearningPath(learningPath, escritor);
            }
        }
    }

    private void guardarLearningPath(LearningPath learningPath, PrintWriter escritor) {
        escritor.print(learningPath.getId() + ";" + learningPath.getNombre() + ";" + learningPath.getdescripcion());
        for (Activity actividad : learningPath.getactividad()) {
            escritor.print(";" + actividad.getId());
        }
        escritor.println(); // Nueva línea para el siguiente LearningPath
    }

    public void leerLearningPaths() throws IOException {
        learningPaths.clear(); // Limpiar antes de cargar
        try (BufferedReader lector = new BufferedReader(new FileReader(LEARNING_PATHS_FILE))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                LearningPath learningPath = leerLearningPath(linea);
                if (learningPath != null) {
                    learningPaths.put(learningPath.getIdPath(), learningPath);
                }
            }
        }
    }

    private LearningPath leerLearningPath(String linea) {
        String[] datos = linea.split(";");
        Long id = Long.parseLong(datos[0]);
        String nombre = datos[1];
        String descripcion = datos[2];
        LearningPath learningPath = new LearningPath(nombre, descripcion);
        learningPath.setidPath(id);

        for (int i = 3; i < datos.length; i++) {
            Long actividadId = Long.parseLong(datos[i]);
            Activity actividad = actividades.get(actividadId); // Recuperar actividad previamente cargada
            if (actividad != null) {
                learningPath.addActivity(actividad);
            }
        }
        return learningPath;
    }

    // Métodos para acceder a las actividades y LearningPaths
    public HashMap<Long, Activity> getActividades() {
        return actividades;
    }

    public HashMap<Long, LearningPath> getLearningPaths() {
        return learningPaths;
    }

    // Métodos para añadir y eliminar actividades o LearningPaths si es necesario
    public void agregarActividad(Activity actividad) {
        actividades.put(actividad.getId(), actividad);
    }

    public void eliminarActividad(Long id) {
        actividades.remove(id);
    }

    public void agregarLearningPath(LearningPath learningPath) {
        learningPaths.put(learningPath.getId(), learningPath);
    }


}