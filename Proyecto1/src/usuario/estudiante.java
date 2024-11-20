package usuario;
import java.util.List;

import actividades.Activity;
import java.util.ArrayList;

public class estudiante extends Usuario {
    private float progreso;
    private List<Activity> actividadesAsignadas;

    // Constructor
    public estudiante(String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.progreso = 0.0f; // El progreso inicial es 0%
        this.actividadesAsignadas = new ArrayList<>();
    }

    // Método para consultar el progreso del estudiante
    public float consultarProgreso() {
        System.out.println("Progreso del estudiante " + getNombre() + ": " + progreso + "%");
        return progreso;
    }

    // Método para actualizar el progreso del estudiante
    public void actualizarProgreso(float nuevoProgreso) {
        if (nuevoProgreso >= 0 && nuevoProgreso <= 100) {
            this.progreso = nuevoProgreso;
            System.out.println("Progreso actualizado para " + getNombre() + ": " + progreso + "%");
        } else {
            System.out.println("Error: El progreso debe estar entre 0 y 100.");
        }
    }

    // Getter para obtener el progreso
    public float getProgreso() {
        return progreso;
    }

    // Setter para establecer el progreso manualmente
    public void setProgreso(float progreso) {
        if (progreso >= 0 && progreso <= 100) {
            this.progreso = progreso;
            System.out.println("Progreso establecido para " + getNombre() + ": " + progreso + "%");
        } else {
            System.out.println("Error: El progreso debe estar entre 0 y 100.");
        }
    }
    public void recibirActividad(Activity actividad) {
        actividadesAsignadas.add(actividad);
    }
    public List<Activity> getActividadesAsignadas() {
        return actividadesAsignadas;
    }
    public void asignarActividad(Activity actividad) {
        actividadesAsignadas.add(actividad);
        System.out.println("Actividad asignada a " + getNombre() + ": " + actividad.getTitulo());
    }

    public void completarActividad(Activity actividad) {
        if (actividadesAsignadas.contains(actividad)) {
            actividad.completar();
            System.out.println("Actividad " + actividad.getTitulo() + " completada por " + getNombre());
        } else {
            System.out.println("La actividad no está asignada al estudiante.");
        }
    }
}

