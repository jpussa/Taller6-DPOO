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

    public Tarea(String string, String string2, boolean b, String string3, String string4, int i, String nombre,
			String string5) {
		// TODO Auto-generated constructor stub
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