import java.util.List;

public class Usuario {
    private Long id;
    private String correo;
    private String contrasena;
    private String rol;
    private List<LearningPath> learningPaths;
    
}

public class LearningPath {
    private Long id;
    private String titulo;
    private String description;
    private Date Date;
    
}

public abstract class Activity {
    private Long id;
    private String titulo;
    private String descripcion;
    private int date;

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


