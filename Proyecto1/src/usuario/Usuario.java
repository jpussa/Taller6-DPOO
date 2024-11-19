package usuario;
import java.util.ArrayList;
import java.util.List;

import logica.LearningPath;


import java.util.List;
import logica.LearningPath;


public class Usuario {
    private Long id;
    private String correo;
    private String usuario;
    private String contrasena;
    private String rol;
    private List<LearningPath> enrolledLearningPaths;
    private boolean loginStatus;

    public Usuario(String correo, String contrasena, String rol) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.enrolledLearningPaths = new ArrayList<>();
        this.loginStatus = false;
    }

    public boolean login(String correo, String contrasena) {
        if (this.correo.equals(correo) && this.contrasena.equals(contrasena)) {
            this.loginStatus = true;
            System.out.println("Inicio de sesión exitoso para: " + id);
            return true;
        }
        System.out.println("Inicio de sesión fallido para: " + id);
        return false;
    }

    public void logout() {
        this.loginStatus = false;
        System.out.println("Sesión cerrada para: " + id);
    }
    // Métodos para obtener detalles del usuario
    public long getUserID() {
        return id;
    }

    public String getNombre() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isLogueado() {
        return loginStatus;
    }
    public void setContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
        System.out.println("Contraseña actualizada para: " + usuario);
    }
    public void setCorreo(String nuevoCorreo) {
        this.correo = nuevoCorreo;
        System.out.println("Correo actualizado para: " + usuario);
    }
}