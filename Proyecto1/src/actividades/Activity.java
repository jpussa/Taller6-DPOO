package actividades;

import java.util.Date;

public abstract class Activity {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;

    public Activity(String titulo, String descripcion, Date fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public abstract boolean completar();
    
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
