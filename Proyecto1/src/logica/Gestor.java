package logica;

import actividades.Activity;
import usuario.estudiante;
import usuario.Profesor;
import java.util.HashMap;
import java.util.List;

public class Gestor {
    private HashMap<Long, Asignacion> asignaciones;

    public Gestor() {
        this.asignaciones = new HashMap<>();
    }

    public void asignarActividad(Profesor profesor, estudiante estudiante, Activity actividad) {
    	Asignacion nuevaAsignacion = new Asignacion(actividad, estudiante);
        asignaciones.put(actividad.getId(), nuevaAsignacion);
        profesor.asignarActividad(estudiante, actividad);
    }

    public List<Asignacion> obtenerAsignacionesEstudiante(estudiante estudiante) {
        return asignaciones.values().stream()
                .filter(asignacion -> asignacion.getEstudiante().equals(estudiante))
                .toList();
    }
}
