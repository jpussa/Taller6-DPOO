package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearActividadUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CrearActividadUI::new);
    }

    public CrearActividadUI() {
        // Crear ventana principal
        JFrame frame = new JFrame("Crear Nueva Actividad");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta de tipo de actividad
        JLabel tipoLabel = new JLabel("Tipo de Actividad:");
        tipoLabel.setBounds(20, 20, 150, 25);
        frame.add(tipoLabel);

        // ComboBox para seleccionar el tipo de actividad
        String[] tiposActividad = {"Encuesta", "Quiz", "Tarea"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tiposActividad);
        tipoComboBox.setBounds(180, 20, 200, 25);
        frame.add(tipoComboBox);

        // Etiqueta y campo de texto para el título
        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setBounds(20, 60, 150, 25);
        frame.add(tituloLabel);

        JTextField tituloField = new JTextField();
        tituloField.setBounds(180, 60, 200, 25);
        frame.add(tituloField);

        // Etiqueta y campo de texto para la descripción
        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(20, 100, 150, 25);
        frame.add(descripcionLabel);

        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(180, 100, 200, 100);
        frame.add(descripcionArea);

        // Panel dinámico para opciones adicionales
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.setBounds(20, 220, 440, 150);
        dynamicPanel.setLayout(null);
        frame.add(dynamicPanel);

        // Actualizar panel dinámico al cambiar tipo de actividad
        tipoComboBox.addActionListener(e -> {
            dynamicPanel.removeAll();
            String tipoSeleccionado = (String) tipoComboBox.getSelectedItem();
            if (tipoSeleccionado != null) {
                switch (tipoSeleccionado) {
                    case "Encuesta":
                        mostrarOpcionesEncuesta(dynamicPanel);
                        break;
                    case "Quiz":
                        mostrarOpcionesQuiz(dynamicPanel);
                        break;
                    case "Tarea":
                        mostrarOpcionesTarea(dynamicPanel);
                        break;
                }
            }
            dynamicPanel.revalidate();
            dynamicPanel.repaint();
        });

        // Botón para guardar la actividad
        JButton guardarButton = new JButton("Guardar Actividad");
        guardarButton.setBounds(180, 400, 150, 30);
        frame.add(guardarButton);

        // Acción del botón guardar
        guardarButton.addActionListener(e -> {
            String tipo = (String) tipoComboBox.getSelectedItem();
            String titulo = tituloField.getText();
            String descripcion = descripcionArea.getText();

            if (titulo.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
                return;
            }

            // Lógica para guardar la actividad dependiendo del tipo
            JOptionPane.showMessageDialog(frame, "Actividad de tipo " + tipo + " creada exitosamente.");
        });

        frame.setVisible(true);
    }

    private void mostrarOpcionesEncuesta(JPanel panel) {
        JLabel preguntaLabel = new JLabel("Agregar Pregunta:");
        preguntaLabel.setBounds(10, 10, 150, 25);
        panel.add(preguntaLabel);

        JTextField preguntaField = new JTextField();
        preguntaField.setBounds(160, 10, 200, 25);
        panel.add(preguntaField);

        JButton addPreguntaButton = new JButton("Agregar");
        addPreguntaButton.setBounds(160, 50, 100, 25);
        panel.add(addPreguntaButton);
    }

    private void mostrarOpcionesQuiz(JPanel panel) {
        JLabel calificacionLabel = new JLabel("Calificación Mínima:");
        calificacionLabel.setBounds(10, 10, 150, 25);
        panel.add(calificacionLabel);

        JTextField calificacionField = new JTextField();
        calificacionField.setBounds(160, 10, 200, 25);
        panel.add(calificacionField);
    }

    private void mostrarOpcionesTarea(JPanel panel) {
        JLabel entregaLabel = new JLabel("Fecha de Entrega:");
        entregaLabel.setBounds(10, 10, 150, 25);
        panel.add(entregaLabel);

        JTextField entregaField = new JTextField();
        entregaField.setBounds(160, 10, 200, 25);
        panel.add(entregaField);
    }
}
