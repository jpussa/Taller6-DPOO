package usuario;
import java.util.ArrayList;
import java.util.List;

import actividades.Activity;
import logica.LearningPath;

public class Profesor extends Usuario {
    private List<LearningPath> cursosCreados;
    private List<Activity> actividadesCreadas;

    // Constructor
    public Profesor(int userID, String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.cursosCreados = new ArrayList<>();
        this.actividadesCreadas = new ArrayList<>();
    }

    // Método para crear un nuevo Learning Path y añadirlo a la lista de cursos creados
    public void crearLearningPath(LearningPath curso) {
        cursosCreados.add(curso);
        System.out.println("Learning Path creado: " + curso.getTitulo() + " por el profesor " + getNombre());
    }

    // Método para editar un Learning Path existente
    public void editarLearningPath(int index, String nuevoTitulo, String nuevaDescripcion) {
        if (index >= 0 && index < cursosCreados.size()) {
            LearningPath curso = cursosCreados.get(index);
            curso.setTitulo(nuevoTitulo);
            curso.setDescripcion(nuevaDescripcion);
            System.out.println("Learning Path actualizado: " + curso.getTitulo() + " por el profesor " + getNombre());
        } else {
            System.out.println("Error: Índice fuera de rango en la lista de cursos creados.");
        }
    }

    // Método para eliminar un Learning Path de la lista de cursos creados
    public void eliminarLearningPath(int index) {
        if (index >= 0 && index < cursosCreados.size()) {
            LearningPath curso = cursosCreados.remove(index);
            System.out.println("Learning Path eliminado: " + curso.getTitulo() + " por el profesor " + getNombre());
        } else {
            System.out.println("Error: Índice fuera de rango en la lista de cursos creados.");
        }
    }

    // Método para obtener la lista de cursos creados
    public List<LearningPath> obtenerCursosCreados() {
        return cursosCreados;
    }
    public void crearactividad(Activity Activity) {
    	actividadesCreadas.add(Activity);
    }
    public void asignarActividad(estudiante estudiante, Activity actividad) {
        estudiante.recibirActividad(actividad);
    }
    public List<Activity> getActividadesCreadas() {
        return actividadesCreadas;
    }
}
