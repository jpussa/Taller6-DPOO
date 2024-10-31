package actividades;

import java.util.Date;

public abstract class Activity {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private String resultado;
    private String creador;

    public Activity(String titulo, String descripcion, Date fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

	public Activity(String titulo2, String tipo, Boolean obligatoriedad, String descripcion2, String objetivo,
			String nivelDificultad, int duracion, String creador) {
		// TODO Auto-generated constructor stub
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
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
}
