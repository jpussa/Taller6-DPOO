package proyecto;
import java.sql.Date;
import java.util.List;
public class Proyecto{
	public class Usuario {
	    private Long id;
	    private String correo;
	    private String contrasena;
	    private String rol;
	    private List<LearningPath> learningPaths;
		public Usuario(String correo, String contrasena, String rol) {
		    this.correo = correo;
		    this.contrasena = contrasena;
		    this.rol = rol;
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
	    private date fecha;
	
	    // Constructor
	    public Activity(String titulo) {
	        this.titulo = titulo;
	    }
	
	
	    public abstract boolean complete();
	}
		
	public class Quiz extends Activity {
	    private List<Question> questions;
	    private float grade;
	}
	
	public class tarea extends Activity {
	    private String entrega;
	    private String status;
	}
	
	public class Survey extends Activity {
	    private List<String> questions;
	}

	}
