package proyecto;
import java.util.Date;
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
		    private Date createdDate;
		    private List<Activity> activities;


		    public LearningPath(String titulo, String descripcionr) {
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
	            
	            public class progreso() {
	            	
	            }

	            }

	       
	        }
	    }
	}
