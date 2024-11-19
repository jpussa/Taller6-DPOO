package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAndMainMenu {

    public static void main(String[] args) {
        // Crear la ventana de login
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 300);
        loginFrame.setLayout(null);

        // Etiqueta de nombre de usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(50, 50, 100, 30);
        loginFrame.add(userLabel);

        // Campo de texto para el usuario
        JTextField userField = new JTextField();
        userField.setBounds(150, 50, 150, 30);
        loginFrame.add(userField);

        // Etiqueta de contraseña
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setBounds(50, 100, 100, 30);
        loginFrame.add(passLabel);

        // Campo de texto para la contraseña
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 30);
        loginFrame.add(passField);

        // Botón para iniciar sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(150, 150, 150, 30);
        loginFrame.add(loginButton);

        // Acción para el botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                // Simulación de autenticación
                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(loginFrame, "Inicio de sesión exitoso.");
                    loginFrame.dispose(); // Cerrar ventana de login
                    showMainMenu(); // Mostrar el menú principal
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Credenciales inválidas. Intente de nuevo.");
                }
            }
        });

        // Hacer visible la ventana de login
        loginFrame.setVisible(true);
    }

    // Método para mostrar el menú principal
    private static void showMainMenu() {
        // Crear la ventana del menú principal
        JFrame mainMenuFrame = new JFrame("Menú Principal");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(600, 400);
        mainMenuFrame.setLayout(null);

        // Etiqueta de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido al Sistema de Learning Paths");
        welcomeLabel.setBounds(150, 20, 300, 30);
        mainMenuFrame.add(welcomeLabel);

        // Botón para ver Learning Paths disponibles
        JButton browsePathsButton = new JButton("Ver Learning Paths");
        browsePathsButton.setBounds(200, 70, 200, 30);
        mainMenuFrame.add(browsePathsButton);

        // Botón para crear nueva actividad
        JButton createActivityButton = new JButton("Crear Nueva Actividad");
        createActivityButton.setBounds(200, 120, 200, 30);
        mainMenuFrame.add(createActivityButton);

        // Botón para dejar una reseña
        JButton leaveReviewButton = new JButton("Dejar una Reseña");
        leaveReviewButton.setBounds(200, 170, 200, 30);
        mainMenuFrame.add(leaveReviewButton);

        // Botón para cerrar sesión
        JButton logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setBounds(200, 220, 200, 30);
        mainMenuFrame.add(logoutButton);

        // Acción para cerrar sesión
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuFrame.dispose(); // Cerrar el menú principal
                JOptionPane.showMessageDialog(null, "Has cerrado sesión.");
                System.exit(0); // Terminar la aplicación
            }
        });

        // Hacer visible el marco del menú principal
        mainMenuFrame.setVisible(true);
    }
}