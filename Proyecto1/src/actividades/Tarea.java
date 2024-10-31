package actividades;

import java.util.Date;

public class Tarea extends Activity {
	private Long id;
    private String entrega;
    private String estado;

    public Tarea(String titulo, String descripcion, Date fecha, String entrega) {
        super(titulo, descripcion, fecha);
        this.entrega = entrega;
        this.estado = "pendiente";
    }

    @Override
    public boolean completar() {
        this.estado = "completada";
        return true;
    }

	public String getEntrega() {
		return entrega;

	}
	public String getestado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setId(Long id) {
		this.id = id;
	}
}