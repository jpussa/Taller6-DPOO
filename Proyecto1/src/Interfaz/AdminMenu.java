package Interfaz;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu {
	private static void showAdminMenu() {
	    JFrame adminMenuFrame = new JFrame("Menú de Administrador");
	    adminMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    adminMenuFrame.setSize(600, 400);
	    adminMenuFrame.setLayout(null);

	    JLabel welcomeLabel = new JLabel("Bienvenido, Administrador");
	    welcomeLabel.setBounds(150, 20, 300, 30);
	    adminMenuFrame.add(welcomeLabel);

	    JButton manageUsersButton = new JButton("Gestionar Usuarios");
	    manageUsersButton.setBounds(200, 70, 200, 30);
	    adminMenuFrame.add(manageUsersButton);

	    JButton systemSettingsButton = new JButton("Configuraciones del Sistema");
	    systemSettingsButton.setBounds(200, 120, 200, 30);
	    adminMenuFrame.add(systemSettingsButton);

	    JButton logoutButton = new JButton("Cerrar Sesión");
	    logoutButton.setBounds(200, 170, 200, 30);
	    adminMenuFrame.add(logoutButton);

	    logoutButton.addActionListener(e -> {
	        adminMenuFrame.dispose();
	        JOptionPane.showMessageDialog(null, "Sesión cerrada.");
	        System.exit(0);
	    });

	    adminMenuFrame.setVisible(true);
	}


}
