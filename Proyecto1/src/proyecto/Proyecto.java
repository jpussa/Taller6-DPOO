package proyecto;
import java.util.Date;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import Logica.LearningPath;
import Actividad.Actividad;
import Actividad.Feedback;
import Logica.Progreso;
import Usuario.Estudiante;
import Usuario.Profesor;
import Usuario.Usuario;
import Logica.Sistema;

import java.util.List;
public class Proyecto{
	public class Usuario {
	    private Long id;
	    private String correo;
	    private String contrasena;
	    private String rol;
	    private List<LearningPath> learningPaths;
	    private boolean loguin;
		public Usuario(String correo, String contrasena, String rol) {
		    this.correo = correo;
		    this.contrasena = contrasena;
		    this.rol = rol;
		    
		    }
	    public int getUserID() {
	        return userID;
	    }

		public boolean login(String correo, String contrasena) {
	        if (this.correo.equals(correo) && this.contrasena.equals(contrasena)) {
	            this.loguin = true;
	            System.out.println("Inicio de sesión exitoso para: " + id);
	            return true;
	        }
	        System.out.println("Inicio de sesión fallido para: " + id);
	        return false;
	    }

	    
	    public void logout() {
	        this.loguin = false;
	        System.out.println("Sesión cerrada para: " + id);
	    }

		public void enrollILP(LearningPath path) {
		    enrolledLP.add(path);
	}
	
		public class LearningPath {
		    private Long id;
		    private String titulo;
		    private String descripcion;
		    private Date fechaLimite;
		    private Date createdDate;
		    private List<Activity> activities;


		    public LearningPath(String titulo, String descripcion) {
		        this.titulo = titulo;
		        this.descripcion = descripcion;
		        this.createdDate = new Date();
		    }

		    public void addActivity(Activity activity) {
		        activities.add(activity);
		        
		    }

		    public float calculateProgress(Usuario user) {
		        return 0.0f;
		    }
		    public void eliminarActividad(int idActivity) {
		        boolean eliminada = activities.removeIf(activity -> activity.getidactivity() == idActivity);
		        if (eliminada) {
		            System.out.println("Actividad eliminada del Learning Path: " + titulo);
		        } else {
		            System.out.println("Actividad con ID " + idActivity + " no encontrada en el Learning Path: " + titulo);
		        }
		    }

		}
	

	 public abstract class Activity {
	        private Long id;
	        private String titulo;
	        private String descripcion;
	        private Date fecha;

	        public Activity(String titulo, String descripcion, Date fecha) {
	            this.titulo = titulo;
	            this.descripcion = descripcion;
	            this.fecha = fecha;
	        }

	        public abstract boolean completar();
	    }

		
	 public class Quiz extends Activity {
	        private List<Question> preguntas;
	        private float calificacionMinima;

	        public Quiz(String titulo, String descripcion, Date fecha, float calificacionMinima, List<Question> preguntas) {
	            super(titulo, descripcion, fecha);
	            this.calificacionMinima = calificacionMinima;
	            this.preguntas = preguntas;
	        }


	        public boolean completar() {

	            return false;
	        }
	    }

	
	    public class Tarea extends Activity {
	        private String entrega;
	        private String estado;

	        public Tarea(String titulo, String descripcion, Date fecha, String entrega) {
	            super(titulo, descripcion, fecha);
	            this.entrega = entrega;
	            this.estado = "pendiente";  // Estado inicial de la tarea
	        }

	        @Override
	        public boolean completar() {
	            this.estado = "completada";
	            return true;
	        }
	    }
	    

	
	    public class Encuesta extends Activity {
	        private List<String> preguntas;

	        public Encuesta(String titulo, String descripcion, Date fecha, List<String> preguntas) {
	            super(titulo, descripcion, fecha);
	            this.preguntas = preguntas;
	        }

	        @Override
	        public boolean completar() {

	            return true;}
	            private void calcularRatingPromedio() {
	                float total = 0;
	                for (float calificacion : calificaciones) {
	                    total += calificacion;
	                }
	                this.rating = calificaciones.isEmpty() ? 0 : total / calificaciones.size();
	            }
	        public class Question {
	        	private String text;
	        	private List<String> options; 
	        	private int correctOptionIndex; 

	              
	            public Question(String text, List<String> options, int correctOptionIndex) {
	               this.text = text;
	               this.options = options;
	               this.correctOptionIndex = correctOptionIndex;
	             }

	            public boolean isCorrect(int selectedOptionIndex) {
	                return selectedOptionIndex == correctOptionIndex;}
	            

	            }

	       
	        }
	    public class ManejadorDePersistencia {

	        private Sistema sistema;
	        private static final String USUARIOS_FILE = "./data/usuarios.txt";
	        private static final String LEARNING_PATHS_FILE = "./data/learningPaths.txt";

	        public ManejadorDePersistencia(Sistema sistema) {
	            this.sistema = sistema;
	        }

	        // MÉTODO PARA GUARDAR USUARIOS
	        public void guardarUsuarios() throws IOException {
	            try (PrintWriter escritor = new PrintWriter(new File(USUARIOS_FILE))) {
	                HashMap<String, Usuario> usuarios = sistema.getUsuarios();
	                for (Usuario usuario : usuarios.values()) {
	                    guardarUsuario(usuario, escritor);
	                }
	            }
	        }

	        // MÉTODO AUXILIAR PARA GUARDAR CADA USUARIO
	        private void guardarUsuario(Usuario usuario, PrintWriter escritor) {
	            escritor.print(usuario.getLogin() + ";" + usuario.getContrasena() + ";" + usuario.getRol());

	            if (usuario instanceof Estudiante) {
	                guardarEstudiante((Estudiante) usuario, escritor);
	            } else if (usuario instanceof Profesor) {
	                guardarProfesor((Profesor) usuario, escritor);
	            }
	            escritor.println();
	        }

	        // GUARDAR INFORMACIÓN ESPECÍFICA DEL ESTUDIANTE
	        private void guardarEstudiante(Estudiante estudiante, PrintWriter escritor) {
	            escritor.print(";" + estudiante.getIntereses() + ";" + estudiante.getActividadEnProgreso());
	            HashMap<String, Progreso> progresos = estudiante.getProgresos();
	            escritor.print(";" + progresos.size());
	            for (String titulo : progresos.keySet()) {
	                escritor.print(";" + titulo);
	            }
	        }

	        // GUARDAR INFORMACIÓN ESPECÍFICA DEL PROFESOR
	        private void guardarProfesor(Profesor profesor, PrintWriter escritor) {
	            HashMap<String, LearningPath> creaciones = profesor.getCreaciones();
	            escritor.print(";" + creaciones.size());
	            for (String titulo : creaciones.keySet()) {
	                escritor.print(";" + titulo);
	            }
	        }

	        // MÉTODO PARA LEER USUARIOS DESDE ARCHIVO
	        public void leerUsuarios() throws IOException {
	            HashMap<String, Usuario> usuarios = new HashMap<>();
	            try (BufferedReader lector = new BufferedReader(new FileReader(USUARIOS_FILE))) {
	                String linea;
	                while ((linea = lector.readLine()) != null) {
	                    Usuario usuario = leerUsuario(linea);
	                    usuarios.put(usuario.getLogin(), usuario);
	                }
	            }
	            sistema.setUsuarios(usuarios);
	        }

	        // MÉTODO AUXILIAR PARA LEER CADA USUARIO
	        private Usuario leerUsuario(String linea) {
	            String[] datos = linea.split(";");
	            String login = datos[0];
	            String contrasena = datos[1];
	            String rol = datos[2];

	            if (rol.equalsIgnoreCase("Estudiante")) {
	                return leerEstudiante(datos);
	            } else if (rol.equalsIgnoreCase("Profesor")) {
	                return leerProfesor(datos);
	            } else {
	                return new Usuario(login, contrasena) {
	                    @Override
	                    public String getRol() {
	                        return rol;
	                    }
	                };
	            }
	        }

	        // MÉTODO PARA LEER DATOS DEL ESTUDIANTE
	        private Estudiante leerEstudiante(String[] datos) {
	            String login = datos[0];
	            String contrasena = datos[1];
	            String intereses = datos[3];
	            boolean actividadEnProgreso = Boolean.parseBoolean(datos[4]);
	            int numProgresos = Integer.parseInt(datos[5]);

	            Estudiante estudiante = new Estudiante(login, contrasena, intereses);
	            estudiante.setActividadEnProgreso(actividadEnProgreso);

	            HashMap<String, Progreso> progresos = new HashMap<>();
	            for (int i = 0; i < numProgresos; i++) {
	                String titulo = datos[6 + i];
	                Progreso progreso = new Progreso(LocalDateTime.now(), sistema.getLearningPaths().get(titulo));
	                progresos.put(titulo, progreso);
	            }
	            estudiante.setProgresos(progresos);
	            return estudiante;
	        }

	        // MÉTODO PARA LEER DATOS DEL PROFESOR
	        private Profesor leerProfesor(String[] datos) {
	            String login = datos[0];
	            String contrasena = datos[1];
	            int numCreaciones = Integer.parseInt(datos[3]);

	            Profesor profesor = new Profesor(login, contrasena);
	            HashMap<String, LearningPath> creaciones = new HashMap<>();
	            for (int i = 0; i < numCreaciones; i++) {
	                String titulo = datos[4 + i];
	                LearningPath lp = sistema.getLearningPaths().get(titulo);
	                creaciones.put(titulo, lp);
	            }
	            profesor.setCreaciones(creaciones);
	            return profesor;
	        }

	        // MÉTODOS PARA GUARDAR Y LEER LEARNING PATHS
	        public void guardarLearningPaths() throws IOException {
	            try (PrintWriter escritor = new PrintWriter(new File(LEARNING_PATHS_FILE))) {
	                HashMap<String, LearningPath> learningPaths = sistema.getLearningPaths();
	                for (LearningPath path : learningPaths.values()) {
	                    guardarLearningPath(path, escritor);
	                }
	            }
	        }

	        private void guardarLearningPath(LearningPath path, PrintWriter escritor) {
	            escritor.print(path.getTitulo() + ";" + path.getDescripcion() + ";" + path.getObjetivos() + ";" + path.getNivelDificultad());
	            HashMap<String, Actividad> actividades = path.getActividades();
	            escritor.print(";" + actividades.size());
	            for (String titulo : actividades.keySet()) {
	                escritor.print(";" + titulo);
	            }

	            ArrayList<Feedback> feedbacks = new ArrayList<>();
	            for (Actividad actividad : actividades.values()) {
	                feedbacks.addAll(actividad.getFeedbacks());
	            }
	            escritor.print(";" + feedbacks.size());
	            for (Feedback fb : feedbacks) {
	                escritor.print(";" + fb.getResena() + ";" + fb.getRating());
	            }
	            escritor.println();
	        }

	        public void leerLearningPaths() throws IOException {
	            HashMap<String, LearningPath> learningPaths = new HashMap<>();
	            try (BufferedReader lector = new BufferedReader(new FileReader(LEARNING_PATHS_FILE))) {
	                String linea;
	                while ((linea = lector.readLine()) != null) {
	                    LearningPath path = leerLearningPath(linea);
	                    learningPaths.put(path.getTitulo(), path);
	                }
	            }
	            sistema.setLearningPaths(learningPaths);
	        }

	        private LearningPath leerLearningPath(String linea) {
	            String[] datos = linea.split(";");
	            String titulo = datos[0];
	            String descripcion = datos[1];
	            String objetivos = datos[2];
	            String nivelDificultad = datos[3];

	            LearningPath path = new LearningPath(titulo, descripcion, objetivos, nivelDificultad, null);
	            int numActividades = Integer.parseInt(datos[4]);
	            HashMap<String, Actividad> actividades = new HashMap<>();
	            for (int i = 0; i < numActividades; i++) {
	                String tituloActividad = datos[5 + i];
	                Actividad actividad = sistema.getActividades().get(tituloActividad);
	                if (actividad != null) {
	                    actividades.put(tituloActividad, actividad);
	                }
	            }
	            path.setActividades(actividades);

	            return path;
	        }
	    }
	    
	    }
	
	}
