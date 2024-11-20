package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAndMainMenu {

	// Corrección completa del flujo de credenciales y visibilidad de ventanas

	public static void main(String[] args) {
	    JFrame loginFrame = new JFrame("Login");
	    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    loginFrame.setSize(400, 300);
	    loginFrame.setLayout(null);

	    JLabel userLabel = new JLabel("Usuario:");
	    userLabel.setBounds(50, 50, 100, 30);
	    loginFrame.add(userLabel);

	    JTextField userField = new JTextField();
	    userField.setBounds(150, 50, 150, 30);
	    loginFrame.add(userField);

	    JLabel passLabel = new JLabel("Contraseña:");
	    passLabel.setBounds(50, 100, 100, 30);
	    loginFrame.add(passLabel);

	    JPasswordField passField = new JPasswordField();
	    passField.setBounds(150, 100, 150, 30);
	    loginFrame.add(passField);

	    JButton loginButton = new JButton("Iniciar Sesión");
	    loginButton.setBounds(150, 150, 150, 30);
	    loginFrame.add(loginButton);

	    loginButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String username = userField.getText();
	            String password = new String(passField.getPassword());

	            if (username.equals("admin") && password.equals("1234")) {
	                JOptionPane.showMessageDialog(loginFrame, "Inicio de sesión exitoso.");
	                loginFrame.dispose();
	                showMainMenu();
	            } else if (username.equals("studiante") && password.equals("1234")) {
	                JOptionPane.showMessageDialog(loginFrame, "Inicio de sesión exitoso.");
	                loginFrame.dispose();
	                showMainMenuEstudiante();
	            } else {
	                JOptionPane.showMessageDialog(loginFrame, "Credenciales inválidas.");
	            }
	        }
	    });

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
                // Hacer visible el marco del menú principal
                mainMenuFrame.setVisible(true);
            }
        });
    }
        private static void showMainMenuEstudiante() {
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
                    // Hacer visible el marco del menú principal
                    
                }

                
            });
            mainMenuFrame.setVisible(true);
        }
        public static void showLearningPathsE() {
            // Crear la ventana del menú principal
            JFrame pathFrame = new JFrame("Learning Paths ");
            pathFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pathFrame.setSize(600, 400);
            pathFrame.setLayout(null);

            // Etiqueta de bienvenida
            JLabel welcomeLabel = new JLabel("Learning Paths Disponibles");
            welcomeLabel.setBounds(150, 20, 300, 30);
            pathFrame.add(welcomeLabel);

            // Botón para ver Learning Paths disponibles
            JButton browsePathsButton = new JButton("Lerning path1");
            browsePathsButton.setBounds(200, 70, 200, 30);
            pathFrame.add(browsePathsButton);
            
            // Botón para ver Learning Paths disponibles
            JButton browsePathsButton1 = new JButton("Lerning path2");
            browsePathsButton1.setBounds(200, 70, 200, 30);
            pathFrame.add(browsePathsButton1);
            

            // Botón para cerrar sesión
            JButton logoutButton = new JButton("Volver");
            logoutButton.setBounds(200, 220, 200, 30);
            pathFrame.dispose();
            showMainMenuEstudiante();

            // Acción para cerrar sesión
            logoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	pathFrame.dispose(); // Cerrar el menú principal
                    JOptionPane.showMessageDialog(null, "Has cerrado sesión.");
                    System.exit(0); // Terminar la aplicación
                    // Hacer visible el marco del menú principal
                    pathFrame.setVisible(true);
                }
            });
            pathFrame.setVisible(true);
        }
}
        