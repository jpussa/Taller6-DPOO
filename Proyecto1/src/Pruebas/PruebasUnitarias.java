package pruebas;

import usuario.*;
import logica.*;
import actividades.*;

public class PruebasUnitarias {
    public static void main(String[] args) {
        probarLoginUsuario();
        probarCreacionLearningPath();
        probarAsignacionActividad();
        // Puedes llamar a más métodos de prueba aquí
    }

    public static void probarLoginUsuario() {
        Usuario usuario = new Usuario("Ana Gómez", "ana@example.com", "pass123");
        boolean resultadoLoginExitoso = usuario.login("ana@example.com", "pass123");
        assert resultadoLoginExitoso : "El inicio de sesión debería ser exitoso con credenciales correctas";

        boolean resultadoLoginFallido = usuario.login("ana@example.com", "contraseñaIncorrecta");
        assert !resultadoLoginFallido : "El inicio de sesión debería fallar con credenciales incorrectas";

        System.out.println("Prueba de login de usuario completada exitosamente.");
    }

    public static void probarCreacionLearningPath() {
        Profesor profesor = new Profesor(0, "Carlos Ruiz", "carlos@example.com", "profPass");
        LearningPath lp = new LearningPath("Matemáticas Avanzadas", "Curso de matemáticas para nivel avanzado");
        profesor.crearLearningPath(lp);

        assert profesor.obtenerCursosCreados().contains(lp) : "El Learning Path debería estar en la lista de cursos creados por el profesor";

        System.out.println("Prueba de creación de Learning Path completada exitosamente.");
    }

    public static void probarAsignacionActividad() {
        Profesor profesor = new Profesor(0, "Laura Díaz", "laura@example.com", "profPass");
        estudiante estudiante = new estudiante("Miguel Torres", "miguel@example.com", "estPass");

        Activity actividad = new Tarea(
                "Ensayo sobre Historia",
                "Escribir un ensayo sobre la Revolución Industrial",
                true,
                "Desarrollar habilidades de escritura",
                "Intermedio",
                120,
                profesor.getNombre(),
                "Entrega en formato PDF"
        );

        profesor.asignarActividad(estudiante, actividad);

        assert estudiante.getActividadesAsignadas().contains(actividad) : "La actividad debería estar asignada al estudiante";

        System.out.println("Prueba de asignación de actividad completada exitosamente.");
    }
}