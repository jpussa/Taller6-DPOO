package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Diario;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante(VentanaPrincipal principal) 
    {
        this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        // Agregar el panel donde va a estar el mapa
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Crear y agregar el panel para editar los detalles del restaurante
        panelDetalles = new PanelEditarRestaurante();
        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelDetalles, BorderLayout.CENTER);

        // Crear y agregar el panel de botones
        panelBotones = new PanelBotonesAgregar(this);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        // Terminar de configurar la ventana
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante() 
    {
        // Obtener los datos ingresados por el usuario
        String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();
        int[] coordenadas = panelMapa.getCoordenadas();
        int x = coordenadas[0];
        int y = coordenadas[1];

        // Usar la ventana principal para agregar el restaurante
        ventanaPrincipal.agregarRestaurante(nombre,calificacion,x,y,visitado);

        // Cerrar la ventana
        dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
