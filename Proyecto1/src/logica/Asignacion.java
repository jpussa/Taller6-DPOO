package logica;

import java.util.ArrayList;
import java.util.List;

import actividades.Activity;
import usuario.estudiante;

public class Asignacion {
    private Activity actividad;
    private List<estudiante> estudiantes;
    private boolean completada;
    private List<String> feedbacks;

    public Asignacion(Activity actividad, usuario.estudiante estudiante) {
        this.actividad = actividad;
        this.estudiantes = new ArrayList<>();
        this.completada = false;
        this.feedbacks = new ArrayList<>();
    }
    public void agregarestudiante(estudiante estudiante ) {
    	if (estudiante != null) {
    		estudiantes.add(estudiante);
    		
    	}
    }


	public void completar() {
        this.completada = true;
        actividad.completar();
    }

    public Activity getActividad() {
        return actividad;
    }

    public List<estudiante> getEstudiantes(String correo) {
        return estudiantes;
    }

    public boolean isCompletada() {
        return completada;
    }
    
    public void agregarFeedback(String feedback) {
    	if (feedback != null && !feedback.isEmpty()) {}
    	feedbacks.add(feedback);
    }
}