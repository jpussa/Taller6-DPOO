package logica;

public class Feedback {

    private String resena;  // Reseña de la actividad
    private int rating;     // Calificación (entre 0 y 10), o sin calificar
    
    private static final int UNRATED = -1;  // Constante para indicar sin calificar

    // Constructor solo con reseña
    public Feedback(String resena) throws IllegalArgumentException {
        if (resena == null || resena.trim().isEmpty()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía.");
        }
        this.resena = resena;
        this.rating = UNRATED;  // Por defecto, sin calificar
    }

    // Constructor con reseña y calificación
    public Feedback(String resena, int rating) throws IllegalArgumentException {
        if (resena == null || resena.trim().isEmpty()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía.");
        }
        validarRating(rating);  // Valida el rango del rating
        this.resena = resena;
        this.rating = rating;
    }

    // Getters
    public String getResena() {
        return resena;
    }

    public int getRating() {
        return rating;
    }

    // Setter para actualizar la reseña
    public void setResena(String resena) throws IllegalArgumentException {
        if (resena == null || resena.trim().isEmpty()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía.");
        }
        this.resena = resena;
    }

    // Validación y configuración del rating
    public void setRating(int rating) throws IllegalArgumentException {
        validarRating(rating);
        this.rating = rating;
    }

    // Método privado para validar la calificación
    private void validarRating(int rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("El rating debe estar entre 0 y 10.");
        }
    }

    // Método para verificar si tiene calificación
    public boolean estaCalificado() {
        return this.rating != UNRATED;
    }

    @Override
    public String toString() {
        if (estaCalificado()) {
            return "Reseña: " + resena + " | Rating: " + rating;
        } else {
            return "Reseña: " + resena + " | Sin calificación";
        }
    }
}
