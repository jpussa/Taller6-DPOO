package usuario;

public class estudiante extends Usuario {
    private float progreso;

    // Constructor
    public estudiante(int userID, String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.progreso = 0.0f; // El progreso inicial es 0%
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
}

