package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "nuevo";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "ver";

    private JButton butNuevo;
    private JButton butCerrar;

    /**
     * La ventana principal de la aplicación
     */
    //Clase vacia que simula la ventana ya creada por otra clase
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar(VentanaAgregarRestaurante ventanaPrincipal) 
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout(new FlowLayout());

        // Botón para crear restaurante
        butNuevo = new JButton("Crear Restaurante");
        butNuevo.setActionCommand("crear");
        butNuevo.addActionListener(this);
        add(butNuevo);

        // Botón para cerrar ventana
        butCerrar = new JButton("Cancelar");
        butCerrar.setActionCommand("cerrar");
        butCerrar.addActionListener(this);
        add(butCerrar);
    }

    @Override
    // Este public es para ejecutar las clases segun el boton que se presiona
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        if (comando.equals("crear")) 
        {
            ventanaPrincipal.agregarRestaurante(); // Llama al método de agregar en la ventana
        } 
        else if (comando.equals("cerrar")) 
        {
            ventanaPrincipal.cerrarVentana();
        }
    }
}
