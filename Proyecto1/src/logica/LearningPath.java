package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import actividades.Activity;

public class LearningPath {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fechaLimite;
    private Date createdDate;
    private Date fechaModificacion;
    private List<Activity> activities;

    public LearningPath(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.createdDate = new Date();
        this.activities = new ArrayList<>();
        this.fechaModificacion = new Date();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(int idActivity) {
        boolean removed = activities.removeIf(activity -> activity.getId() == idActivity);
        if (removed) {
            System.out.println("Actividad eliminada del Learning Path: " + titulo);
        } else {
            System.out.println("Actividad con ID " + idActivity + " no encontrada en el Learning Path: " + titulo);
        }
    }
    private void actualizarFechaModificacion() {
        this.fechaModificacion = new Date();
    }
    public long getIdPath() {
        return id;
    }
    


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        actualizarFechaModificacion();
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        actualizarFechaModificacion();
    }
    







    // Método para calcular el progreso, getters y setters...
}
