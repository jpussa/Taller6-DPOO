package logica;

import actividades.Activity;
import usuario.estudiante;

public class Asignacion {
    private Activity actividad;
    private estudiante estudiante;
    private boolean completada;

    public Asignacion(Activity actividad, usuario.estudiante estudiante) {
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.completada = false;
    }


	public void completar() {
        this.completada = true;
        actividad.completar();
    }

    public Activity getActividad() {
        return actividad;
    }

    public estudiante getEstudiante() {
        return estudiante;
    }

    public boolean isCompletada() {
        return completada;
    }
}