package logica;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import actividades.Activity;
import actividades.Encuesta;
import actividades.Quiz;
import actividades.Tarea;
import preguntas.Pregunta;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	    //";" es el delimitador de la linea
	    String[] datos = linea.split(";");
	    // caso Encuesta
//	                                                       (pregunta1)                                                (pregunta2) 
	    // tipo;id;titulo;descripcion;date;numberOfPreguntas; enunciado1 ; option1,option2,option3 ; indexCorrectAnswer ;enunciado2; option1,option2,option3 
	    
	    // caso Quiz
//       													 (pregunta1)                                                (pregunta2) 	    
	    // tipo;id;titulo;descripcion;date;numberOfPreguntas; enunciado1 ; option1,option2,option3 ; indexCorrectAnswer ;enunciado2; option1,option2,option3 

	    //Mapeamos los primero 4 tipos para diferenciar su tipo y cierta informacion que no cambia
	    String tipo = datos[0];
	    Long id = Long.parseLong(datos[1]); // Convertir ID a Long 
	    String titulo = datos[2];
	    String descripcion = datos[3];

	    Date fecha = new Date(); // here you are not taking the date from linea


	    switch (tipo) { //the "linea" changes are "tipo"-based
	    case "Encuesta":
	        
	        //we have to do the same here
	        int numPreguntasEncuesta = Integer.parseInt(datos[5]);

	        
	        List<Pregunta> preguntas = new ArrayList<>();


	        for (int i = 0; i < numPreguntasEncuesta; i++) {
	            int questionCoefficent = i*3; // this is the space, in the file positions, that each question object takes

	            String enunciado = datos[6 + questionCoefficent];
	            String[] optionsCadena = datos[7 + questionCoefficent].split(",");
	            List<String> optionsArray =  Arrays.asList(optionsCadena);
	            
	            int correctAnswerIndex = Integer.parseInt(datos [8 + questionCoefficent]);

	            //we need to CREATE pregunta
	            Pregunta newPregunta = new Pregunta(enunciado, optionsArray, correctAnswerIndex);

	            preguntas.add(newPregunta);
	        }

	        Encuesta encuesta = new Encuesta(titulo, descripcion, fecha, preguntas);
	        encuesta.setId(id); // Establecer el ID
	        return encuesta;
	    case "Quiz":
	    	int numPreguntasQuiz = Integer.parseInt(datos[5]);
	    	Date fecha = formatter.parse(datos[4]);
	    	
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


	    //less WEED and more study, group
	    //! tipo is missing ?Java Basics?
	    //! id type is not correct ?Learn the basics of Java? is not a Long (long is a long number practically eg. 125179847192641274912564)
	    //? titulo is correct "Understand basic syntax, variables, loops" its a good title
	    //? descripcion is Beginner (kinda weird if ya ask me)
	    
	    // as I predicted, 2 its not a date, ence its the number of preguntas


	    // Java Basics;Learn the basics of Java;Understand basic syntax, variables, loops;Beginner;2;Activity1;Activity2;3;Great course;5;Interesting content;4

	    // Python for Beginners;Learn Python from scratch;Introduction to Python syntax, loops, and functions;Beginner;3;Activity3;Activity4;Activity5;2;Very helpful;4;Well explained;5

	    // Advanced Java;Master advanced Java concepts;Object-Oriented Programming, multi-threading, streams;Advanced;2;Activity6;Activity7;1;Challenging but rewarding;5

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